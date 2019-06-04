package com.zl.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.zl.vo.VerifyCode;

public class VerifyCodeUtils {
	private static final String[] seeds = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	/**过期时间:单位为分钟*/
	private static final String TIME_OUT = "1";

	/**
	 * 发送短信
	 * 
	 * @param phone
	 * @return 结果码
	 */
	public static int sendMessage(String phone) {
		/** 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的 */
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		/** 生成4位验证码 */
		String code = getMessageCode(4);
		/** 创建post请求 */
		/*** 参数 */
		URI uri = null;
		// 响应模型
		CloseableHttpResponse closeableHttpResponse = null;
			 try {
				/** 将参数放入键值对类NameValuePair中,再放入集合中*/
				 List <NameValuePair> parms = new ArrayList<>();
				 parms.add(new BasicNameValuePair("mobile",phone));
				 parms.add(new BasicNameValuePair("tpl_id","159868"));
				 /**#code#=1234&#company#=聚合数据*/
				 parms.add(new BasicNameValuePair("tpl_value",encode(code,TIME_OUT)));
				 parms.add(new BasicNameValuePair("key","850775cacc6ba44fadc63e1a8d0f87de"));
				     
				// 设置uri信息,并将参数集合放入uri;
				// 注:这里也支持一个键值对一个键值对地往里面放setParameter(String key, String value)
				 uri = new URIBuilder().setPath("http://v.juhe.cn/sms/send").setParameters(parms).build();
				 
				 HttpPost httpPost = new HttpPost(uri);
					// 由客户端执行(发送)Post请求
					closeableHttpResponse = httpClient.execute(httpPost);
					// 从响应模型中获取响应实体
					HttpEntity httpEntity = closeableHttpResponse.getEntity();
					System.out.println("响应状态为:" + closeableHttpResponse.getStatusLine());
					if (httpEntity !=null) {
						//System.out.println("响应内容的长度为"+httpEntity.getContentLength());
						//System.out.println("响应内容为"+EntityUtils.toString(httpEntity));
						/**
						 * 输出中调用了2次 EntityUtils.toString(httpEntity) ，
						 * 而根据httpclient的官方说明中，EntityUtils.toString(httpEntity) 这个被调用一次后就会自动销毁，而我调用了2次所有就报错了
						 */
						if (closeableHttpResponse.getStatusLine().getStatusCode()==200) {
							/**将目标JSON字符串转换为实体bean*/
							VerifyCode verifyCode = JSONObject.parseObject(EntityUtils.toString(httpEntity),VerifyCode.class);
							if (verifyCode.getError_code()==0) {
								/**短信发送成功*/
								verifyCode.setPhone(phone);
								verifyCode.setLastTime(new Date());
								verifyCode.setCode(code);
								UserContext.setVerifyCode(verifyCode);
								return Err.SUCESS;
							}else {
								System.out.println("==================Err.ERR_PHONE_SEND_MSG"+Err.ERR_PHONE_SEND_MSG);
								return Err.ERR_PHONE_SEND_CODE;
							}
						}
					}
					
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				/**关闭资源*/
				try {
					/**先关httpClient 再关closeableHttpResponse*/
					if (httpClient !=null) {
						httpClient.close();
					}
					if (closeableHttpResponse !=null) {
						closeableHttpResponse.close();
					}
				} catch (IOException e) {
					return Err.ERR_SYSTEM_CODE;
				}
			}
			 return Err.ERR_SYSTEM_CODE;
	}

	/**
	 * 生成验证码
	 * 
	 * @param len 要生成的验证码的长度
	 * @return len位数的验证码
	 */
	private static String getMessageCode(int len) {
		if (len <= 0) {
			throw new RuntimeException("length" + len);
		}
		if (len >= 11) {/** 如果验证码长度超过11的话,将种子定在10,防止数组下标越界*/
			return getRandomNum(10, len);
		} else {
			return getRandomNum(len);
		}
	}

	/**
	 * 没超过10位的验证码采用这个方法生成验证码
	 * 
	 * @return 验证码
	 */
	private static String getRandomNum(int len) {
		Random ram = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int n = ram.nextInt(len);
			sb.append(seeds[n]);
		}
		return sb.toString();
	}

	/**
	 * 超过10位的验证码采用这个方法生成验证码
	 * 
	 * @param seed 种子
	 * @param len  要生成验证码的位数
	 * @return 验证码
	 */
	public static String getRandomNum(int seed, int len) {
		Random ram = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int n = ram.nextInt(seed);
			sb.append(seeds[n]);
		}
		return sb.toString();
	}

	/**
	 * 编码
	 * @param code 验证码
	 * @param timeOut 过期时间
	 * @return 编码后的信息
	 */
	public static String encode(String code,String timeOut) {
		StringBuffer  sb = new StringBuffer("#code#=");
		//StringBuffer  sb = new StringBuffer();
		sb.append(code);
		sb.append("&#m#=");
		//sb.append("&");
		sb.append(timeOut);
	    try {
			return URLEncoder.encode(sb.toString(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}

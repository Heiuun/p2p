package com.zl.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 短信验证消息类
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class VerifyCode implements Serializable{

	private static final long serialVersionUID = 1L;
	/**手机号*/
	private String phone;
	/**验证码*/
	private String code;
	/**最后一次发送成功的时间*/
	private Date lastTime;
	/**发送状态*/
	private String reason;
	/**发送的状态码*/
	private Integer error_code;
}

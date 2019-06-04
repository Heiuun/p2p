package com.zl.utils;

/**
 * 认证工具类
 *
 */
public class AuthUtils {
	/**实名认证未通过*/
	public static final int REAL_AUTH_UNPASS = -1;
	/**实名认证待审核*/
	public static final int REAL_AUTH_WAIT = 0;
	/**实名认证已通过*/
	public static final int REAL_AUTH_PASS = 1;
	
	/**VIP认证未通过*/
	public static final int VIP_AUTH_UNPASS = -1;
	/**VIP认证待审核*/
	public static final int VIP_AUTH_WAIT = 0;
	/**VIP认证已通过*/
	public static final int VIP_AUTH_PASS = 1;
	
	
	/**手机认证码*/
	public static final int PHONE_AUTH_CODE = 1<<0;
	/**邮箱认证码*/
	public static final int MAIL_AUTH_CODE = 1<<1;
	
	/**
	 * 是否已认证
	 * @param bitState 状态码
	 * @param code 认证码
	 * @return true 已认证 false 未认证
	 */
	public static boolean isAuth(Long bitState,Integer code) {
		return (bitState&code) > 0;
	}
	
	/**
	 * 添加授权
	 * @param bitState 状态码
	 * @param code 认证码
	 * @return 认证后的状态码
	 */
	public static long addAuth(Long bitState,Integer code) {
		return bitState|code;
	}
	
	/**
	 * 移除授权
	 * @param biteState 状态码
	 * @param code 认证码
	 * @return 认证后的状态码
	 */
	public static long removeAuth(Integer bitState,Integer code) {
		return bitState^code;
	}

}

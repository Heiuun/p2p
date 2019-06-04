package com.zl.utils;

/**
 * 错误码以及错误提示信息
 */
public class Err {
	private Err() {

	}

	/** 系统未知异常:0000 */
	public static final int ERR_SYSTEM_CODE = 0000;
	public static final String ERR_SYSTEM_MSG = "系统未知异常,请联系管理员!!";
	
	/** 成功 */
	public static final int SUCESS = 1000;

	public static final String SUCESS_MSG = "成功!";

	/** 用户已被锁:1001 */
	public static final int ACCOUNT_LOCK_CODE = 1001;
	/** 用户已被锁 */
	public static final String ACCOUNT_LOCK_MSG = "用户已被锁,请联系管理员";

	/** 用户已被注销:1002 */
	public static final int ACCOUNT_DEL_CODE = 1002;
	/** 用户已被注销 */
	public static final String ACCOUNT_DEL_MSG = "用户已被注销,请联系管理员";

	/** 无效登陆,用户名或密码为空:1003 */
	public static final int INVALID_LOGIN_CODE = 1003;
	public static final String INVALID_LOGIN_MSG = "用户名或密码不能为空";

	/** 用户名或密码错误:1004 */
	public static final int ERR_LOGIN_CODE = 1004;
	public static final String ERR_LOGIN_MSG = "用户名或密码错误";
	
	
	/** 注册失败:2001 */
	public static final int ERR_REGIEST_CODE = 2001;
	public static final String ERR_REGIEST_MSG = "注册失败!!";
	
	
	/** 短信发送失败:2002 */
	public static final int ERR_PHONE_SEND_CODE = 2002;
	/** 短信发送失败 */
	public static final String ERR_PHONE_SEND_MSG = "短信发送失败!!";
	
	/** 重复发送短信:2002 */
	public static final int ERR_REPEAT_SEND_CODE = 2003;
	/** 短信发送失败 */
	public static final String ERR_REPEAT_SEND_MSG = "操作太快，请稍等一会在试!!";
	
	/** 短信验证失败:2004 */
	public static final int ERR_PHONE_VERIFY_CODE = 2004;
	/** 短信验证失败 */
	public static final String ERR_PHONE_VERIFY_MSG = "短信验证失败!!";
	
	
	
}

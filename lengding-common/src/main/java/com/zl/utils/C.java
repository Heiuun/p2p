package com.zl.utils;

import java.math.BigDecimal;

/**
 * 常量类
 * 
 * @author Administrator
 *
 */
public class C {
	private C() {
	}

	/** 允许上传的图片类型:png,gif,jpg */
	public static final String[] IMGS_TYPE = { ".png", ".gif", ".jpg" };

	/** 普通用户 */
	public static final int USERTYPE_NORMAL = 0;
	/** 管理员 */
	public static final int USERTYPE_ADMIN = 1;

	/** 账号已经被注销 */
	public static final int ACCOUNT_DELTED = -1;
	/** 账号被锁定 */
	public static final int ACCOUNT_LOCKED = 0;
	/** 账号正常 */
	public static final int ACCOUNT_NORMAL = 1;

	/** 登录失败 */
	public static final int LOGIN_FALIED = -1;
	/** 登陆成功 */
	public static final int LOGIN_SUCCESS = 1;

	
	
}

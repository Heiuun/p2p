package com.zl.utils;


import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zl.entity.loginInfo.LoginInfo;
import com.zl.vo.VerifyCode;


/**
 * 取session对象
 * 
 * @author Administrator
 *
 */
public class UserContext {
	private static String USER_IN_SESSION = "current";
	private static String VERIFY_CODE = "verifyCode";

	/**
	 * 获取HttpSession
	 * 
	 * @return
	 */

	public static HttpSession getHttpSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}

	/**
	 * 获取当前登陆的用户
	 * @return 当前登陆的用户
	 */
	public static LoginInfo getCurrent() {
		return (LoginInfo) getHttpSession().getAttribute(USER_IN_SESSION);
	}

	/**
	 * 往session域中存入当前登陆的用户
	 * @param loginInfo 当前的登陆用户
	 */
	public static void setCurrent(LoginInfo loginInfo) {
		if (getCurrent() == null) {
			getHttpSession().setAttribute(USER_IN_SESSION, loginInfo);
		}
	}
	
	
	/**
	 * 获取当前短信验证内容
	 * @return 当前短信验证内容
	 */
	public static VerifyCode getVerifyCode() {
		return (VerifyCode) getHttpSession().getAttribute(VERIFY_CODE);
	}

	/**
	 * 往session域中存入当前短信验证内容
	 * @param verifyCode 当前短信验证内容
	 */
	public static void setVerifyCode(VerifyCode verifyCode) {
			getHttpSession().setAttribute(VERIFY_CODE, verifyCode);
	}
	
}

package com.zl.service;


import com.zl.vo.JsonResult;

public interface LoginService {

	/**
	 * 通过用户名和密码登陆
	 * @param nickName 用户名
	 * @param pass 密码
	 * @return JsonResult
	 */
	JsonResult login(String nickName, String pass);
}

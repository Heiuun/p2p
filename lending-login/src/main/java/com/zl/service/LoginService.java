package com.zl.service;

import java.util.Map;

import com.zl.entity.loginInfo.LoginInfo;

public interface LoginService {

	/**
	 * 登陆
	 * @param nickName 用户名
	 * @param pass 密码
	 * @param loginState 状态
	 * @return 用户登录信息
	 */
	LoginInfo login(String nickName, String pass, Integer loginState);

	/**
	 * 获取所有的数据
	 * @param pageNum 第几页
	 * @param pageSize 页容量
	 * @return 所有的状态
	 */
	Map<String, Object> getUserStates(Integer pageNum, Integer pageSize);
}

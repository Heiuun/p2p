package com.zl.dao;

import java.util.List;

import com.zl.entity.loginInfo.UserState;

/**
 * 用户状态
 */
public interface UserStateMapper {

	/**
	 * 查询所有的用户状态
	 * @return 所有的用户状态
	 */
	List<UserState> queryAllStates();

}

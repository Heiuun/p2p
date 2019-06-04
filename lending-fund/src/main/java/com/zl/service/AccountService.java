package com.zl.service;

import com.zl.entity.fund.Account;

public interface AccountService {

	/**
	 * 根据id获取账户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Account queryAllById(Integer id) throws Exception;
}

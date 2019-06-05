package com.zl.service;

import com.zl.entity.fund.BankCard;

public interface BankCardService {

	/**
	 * 根据id获取银行卡信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	BankCard queryAllById(Integer id) throws Exception;
}

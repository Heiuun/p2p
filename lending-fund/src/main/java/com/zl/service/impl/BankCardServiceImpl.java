package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.BankCardMapper;
import com.zl.entity.fund.BankCard;
import com.zl.service.BankCardService;

@Service
public class BankCardServiceImpl implements BankCardService {

	@Autowired
	BankCardMapper bankCardMapper;
	
	@Override
	public BankCard queryAllById(Integer id) throws Exception {
		BankCard bankCard = bankCardMapper.queryAllById(id);
		if(bankCard.getState() == BankCard.BANKCARDSTATE_DELECT) {
			throw new Exception("该银行卡已删除");
		}
		return bankCard;
	}

}

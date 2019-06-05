package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.AccountMapper;
import com.zl.entity.fund.Account;
import com.zl.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public Account queryAllById(Integer id) throws Exception {
		Account account = accountMapper.queryAllById(id);
		if(account.getState() == Account.ACCOUNT_DELECT) {
			throw new Exception("该账户已删除");
		}
		return account;
	}

}

package com.zl.dao;

import org.apache.ibatis.annotations.Param;

import com.zl.entity.fund.Account;

/**
 * 账户信息数据库操作
 * @author Mouse
 *
 */
public interface AccountMapper {

	/**
	 * 根据id查询账户信息表所有信息
	 * 
	 * @param id
	 * @return
	 */
	Account queryAllById(@Param("id") Integer id) throws Exception;
}

package com.zl.dao;

import org.apache.ibatis.annotations.Param;

import com.zl.entity.fund.BankCard;

/**
 * 银行卡数据库操作
 * @author Mouse
 *
 */
public interface BankCardMapper {

	/**
	 * 根据id查询银行卡所有信息
	 * 
	 * @param id
	 * @return
	 */
	BankCard queryAllById(@Param("id") Integer id) throws Exception;
}

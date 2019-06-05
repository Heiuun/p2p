package com.zl.dao;

import org.apache.ibatis.annotations.Param;

import com.zl.entity.fund.Journal;

/**
 * 日志数据库操作
 * @author Mouse
 *
 */
public interface JournalMapper {

	/**
	 * 根据id查询日志表所有信息
	 * 
	 * @param id
	 * @return
	 */
	Journal queryAllById(@Param("id") Integer id) throws Exception;
}

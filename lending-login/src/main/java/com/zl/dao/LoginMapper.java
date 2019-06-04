package com.zl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.zl.entity.loginInfo.LoginInfo;

/**
 * @Mapper //只要在启动器那配置了 @MapperScan("com.zl.dao") 就不需要在每个Mapper接口上加@Mapper注解了
 *
 */
public interface LoginMapper {

	/**
	 * 通过用户名和密码查询用户登录信息
	 * 
	 * @param nickName 用户名
	 * @param pass     密码
	 * @param loginState 状态
	 * @return 用户登录信息
	 */
	LoginInfo queryByNickNameAndPass(@Param("nickName") String nickName, @Param("pass") String pass,@Param("loginState") Integer loginState);

}

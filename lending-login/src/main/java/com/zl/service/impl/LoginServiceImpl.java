package com.zl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.dao.LoginMapper;
import com.zl.dao.UserStateMapper;
import com.zl.entity.loginInfo.LoginInfo;
import com.zl.entity.loginInfo.UserState;
import com.zl.service.LoginService;
/**
 * 登陆信息的实现类
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private UserStateMapper userStateMapper;
	
	@Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOps;
	
	@Override
	//@Transactional //加上该注解即开启了事务
	public LoginInfo login(String nickName, String pass,Integer loginState) {
		LoginInfo loginInfo = loginMapper.queryByNickNameAndPass(nickName,pass,loginState);
		//valueOps.set(loginInfo.getNickName(), loginInfo.getLoginInfoId()+"");
		return loginInfo;
	}

	@Override
	public Map<String, Object> getUserStates(Integer pageNum, Integer pageSize) {
		List<UserState> userStateList = userStateMapper.queryAllStates();
		//PageHelper分页插件使用
		PageHelper.startPage(pageNum, pageSize);
		//将数据库查出的值扔到PageInfo里实现分页效果
		PageInfo<UserState> pageInfo = new PageInfo<>(userStateList);
		//将结果展示到map里
		Map<String, Object> map = new HashMap<>();
		map.put("ret", "0");
		map.put("msg", "SUCCESS");
		map.put("body", pageInfo.getList());//数据结果
		map.put("total", pageInfo.getTotal());//获取数据总数
		map.put("pageSize", pageInfo.getPageSize());//获取长度
		map.put("pageNum", pageInfo.getPageNum());//获取当前页数
		return map;
	}

}

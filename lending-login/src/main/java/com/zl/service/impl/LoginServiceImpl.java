package com.zl.service.impl;

import javax.annotation.Resource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zl.dao.LoginMapper;
import com.zl.dao.UserStateMapper;
import com.zl.entity.loginInfo.LoginInfo;
import com.zl.entity.loginInfo.UserState;
import com.zl.service.LoginService;
import com.zl.utils.Err;
import com.zl.utils.UserContext;
import com.zl.vo.JsonResult;

/**
 * 登陆信息的实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	private UserStateMapper userStateMapper;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;

	@Override
	public JsonResult login(String nickName, String pass) {

		LoginInfo loginInfo = loginMapper.queryByNickNameAndPass(nickName, pass);

		// 查不到用户
		if (loginInfo == null) {
			return new JsonResult(Err.ERR_LOGIN_CODE, Err.ERR_LOGIN_MSG);
		}

		// 用户已注销
		if (loginInfo.getUserState() != null && loginInfo.getUserState().getStateCode() == UserState.DELETED) {
			return new JsonResult(Err.ACCOUNT_DEL_CODE, Err.ACCOUNT_DEL_MSG);
		}

		// 用户被冻结
		if (loginInfo.getUserState() != null && loginInfo.getUserState().getStateCode() == UserState.FORZEN) {
			return new JsonResult(Err.ACCOUNT_LOCK_CODE, Err.ACCOUNT_LOCK_MSG);
		}
		
		//登陆成功
				if (loginInfo.getUserState() != null && loginInfo.getUserState().getStateCode() == UserState.NOMAL) {
					//清除密码
					loginInfo.setPass("");
					//保存用户信息到redis的Session中
					UserContext.setCurrent(loginInfo);
					return new JsonResult(Err.SUCESS, Err.SUCESS_MSG);
				}
		return new JsonResult(Err.ERR_SYSTEM_CODE, Err.ERR_SYSTEM_MSG);
	}

//	@Override
//	//@Transactional //加上该注解即开启了事务
//	public LoginInfo login(String nickName, String pass,Integer loginState) {
//		LoginInfo loginInfo = loginMapper.queryByNickNameAndPass(nickName,pass,loginState);
//		//valueOps.set(loginInfo.getNickName(), loginInfo.getLoginInfoId()+"");//使用redis操作类
//		return loginInfo;
//	}

//	分页示例
//	@Override
//	public Map<String, Object> getUserStates(Integer pageNum, Integer pageSize) {
//		List<UserState> userStateList = userStateMapper.queryAllStates();
//		//PageHelper分页插件使用
//		PageHelper.startPage(pageNum, pageSize);
//		//将数据库查出的值扔到PageInfo里实现分页效果
//		PageInfo<UserState> pageInfo = new PageInfo<>(userStateList);
//		//将结果展示到map里
//		Map<String, Object> map = new HashMap<>();
//		map.put("ret", "0");
//		map.put("msg", "SUCCESS");
//		map.put("body", pageInfo.getList());//数据结果
//		map.put("total", pageInfo.getTotal());//获取数据总数
//		map.put("pageSize", pageInfo.getPageSize());//获取长度
//		map.put("pageNum", pageInfo.getPageNum());//获取当前页数
//		return map;
//	}

}

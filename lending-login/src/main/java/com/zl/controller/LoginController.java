package com.zl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.entity.loginInfo.LoginInfo;
import com.zl.entity.loginInfo.UserState;
import com.zl.service.LoginService;
import com.zl.utils.UserContext;

/**
 * 登陆的控制器
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@ResponseBody
	@RequestMapping("/login")
    public Map<String,LoginInfo> login(HttpSession httpSession){
		Map<String,LoginInfo> map = new HashMap<>();
		String nickName = "zhangsan";
		String pass = "123456";
		Integer loginState = UserState.NOMAL;
		LoginInfo loginInfo = loginService.login(nickName,pass,loginState);
		if (null==httpSession.getAttribute(loginInfo.getNickName())) {
			LoginInfo login = new LoginInfo();
			login.setLoginInfoId(loginInfo.getLoginInfoId());
			UserContext.setCurrent(loginInfo);
		}
		map.put("loginInfo", loginInfo);
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/states")
    public Map<String, Object> userStates(HttpSession httpSession){
		//Map<String,List<UserState>> map = new HashMap<>();
		/**第几页*/
		Integer pageNum = 1;
		/**页容量*/
		Integer pageSize = 2;
		LoginInfo loginInfo = UserContext.getCurrent();
		Map<String, Object> map = loginService.getUserStates(pageNum,pageSize);
		map.put("current", loginInfo);
		return map;
    }
}

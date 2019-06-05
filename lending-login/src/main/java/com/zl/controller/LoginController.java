package com.zl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.zl.entity.loginInfo.LoginInfo;
import com.zl.entity.loginInfo.UserState;
import com.zl.service.LoginService;
import com.zl.utils.Err;
import com.zl.utils.MD5;
import com.zl.utils.UserContext;
import com.zl.vo.JsonResult;

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
    public JsonResult login(String nickName,String pass){
		if (StringUtil.isEmpty(nickName) || StringUtil.isEmpty(pass)) {
			return new JsonResult(Err.INVALID_LOGIN_CODE,Err.INVALID_LOGIN_MSG);
		}
		JsonResult result = loginService.login(nickName,MD5.encode(pass.trim()));
		return result;
    }
	
	@ResponseBody
	@RequestMapping("/loginTest")
    public JsonResult login(){
		String nickName = "lihua";
		String pass = "123456";
		if (StringUtil.isEmpty(nickName) || StringUtil.isEmpty(pass)) {
			return new JsonResult(Err.INVALID_LOGIN_CODE,Err.INVALID_LOGIN_MSG);
		}
		JsonResult result = loginService.login(nickName,MD5.encode(pass.trim()));
		return result;
    }
}

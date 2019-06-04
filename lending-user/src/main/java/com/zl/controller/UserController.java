package com.zl.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.client.LoginServiceClient;
import com.zl.entity.loginInfo.LoginInfo;


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	LoginServiceClient loginServiceClient;
	
	@Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOps;
	
	@ResponseBody
	@RequestMapping("/login")
    public Map<String,LoginInfo> login(){
		Map<String,LoginInfo> map= loginServiceClient.login();
		System.err.println("loginInfoId==========>"+valueOps.get("1"));
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/states")
    public Map<String, Object> userStates(){
		Map<String, Object> map= loginServiceClient.userStates();
		return map;
    }
}

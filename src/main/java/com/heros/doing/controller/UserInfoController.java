package com.heros.doing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.heros.doing.model.UserInfo;
import com.heros.doing.service.CommonService;
import com.heros.doing.service.UserService;
import com.heros.doing.utils.ServerUtil;

@Controller
@RequestMapping(value = "userinfo")
public class UserInfoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class); 
	@Autowired
	CommonService commonService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response, String token, String userId){
		int status = 200;
		String statusText = "ok";
		JSONObject resData = null;
		if(!commonService.checkToken(token)){
			status = 401;
			statusText = "非法token！";
		}else{
			UserInfo userInfo = userService.getUserInfoById(userId);
			resData = new JSONObject();
			resData.put("nickName", userInfo.getNickName());
			resData.put("sex", userInfo.getSex());
			resData.put("age", userInfo.getAge());
			resData.put("occupation", userInfo.getOccupation());
		}
		JSONObject res = ServerUtil.genResJson(status, statusText, resData);
		this.printNoCache(response, res.toJSONString());
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void saveUserInfo(HttpServletRequest request, HttpServletResponse response){
		
	}
}

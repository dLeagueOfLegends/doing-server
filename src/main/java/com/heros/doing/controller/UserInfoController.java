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
import com.heros.doing.utils.ResponseUtil;

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
		JSONObject resData = null;
		try{
			if(!commonService.checkToken(token)){
				ResponseUtil.responseLackParams(response);
				return;
			}else{
				UserInfo userInfo = userService.getUserInfoById(userId);
				resData = new JSONObject();
				resData.put("nickName", userInfo.getNickName());
				resData.put("sex", userInfo.getSex());
				resData.put("age", userInfo.getAge());
				resData.put("occupation", userInfo.getOccupation());
			}
		}catch(Exception e){
			logger.error("getUserInfo error, {}", e);
			ResponseUtil.responseSysError(response);
			return;
		}
		ResponseUtil.responseOK(response, resData);
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void saveUserInfo(HttpServletRequest request, HttpServletResponse response, String userJson){
		JSONObject userObj = null, resData = null;
		try{
			if(userJson != null && userJson.length() > 3){
				userObj = JSONObject.parseObject(userJson);
			}
			if(userObj == null){
				ResponseUtil.responseLackParams(response);
				return;
			}else{
				UserInfo userInfo = new UserInfo();
				userInfo.setAge(userObj.getIntValue("age"));
				userInfo.setNickName(userObj.getString("nickName"));
				userInfo.setSex(userObj.getIntValue("sex"));
				userInfo.setOccupation(userObj.getString("occupation"));
				userService.setUserInfo(userInfo);
			}
		}catch(Exception e){
			logger.error("saveUserInfo error, {}", e);
			ResponseUtil.responseSysError(response);
			return;
		}
		ResponseUtil.responseOK(response, resData);
	}
}

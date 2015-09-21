package com.heros.doing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dminor.baselib.dao.CommonDao;
import com.heros.doing.dao.UserInfoDao;
import com.heros.doing.model.UserInfo;

@Controller
public class HelloController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	CommonDao commonDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(HttpServletRequest request, HttpServletResponse response){
		logger.error("++++++++++++==");
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(123);
		userInfo.setDeviceCode("tttt");
		userInfo.setIconUrl("xxxx");
		userInfo.setIdentificationMobile("1111");
		userInfo.setLastLoginTime(1233);
		userInfo.setNickName("sdsad");
		userInfoDao.addUserInfo(userInfo);
		this.printNoCache(response, "hello.");
	}
}

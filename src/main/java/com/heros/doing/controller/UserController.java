package com.heros.doing.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.encrypt.AESCoder;

@Controller
@RequestMapping(value = "/do")
public class UserController extends BaseController{

	@RequestMapping(value = "gi", method = { RequestMethod.POST })
	public void register(@RequestBody String requestBody, HttpServletResponse response) {
		int status = 200;
		String statusText = "ok";
		String data = AESCoder.decryptBase64ToUtf8(requestBody, AESCoder.defaultPassword);
		if(data == null){
			status = 401;
			statusText = "请求参数错误!";
		}else{
			JSONObject dataJson = JSON.parseObject(data);
			
		}
	}
	
	@RequestMapping(value = "ke", method = { RequestMethod.POST })
	public void getToken(@RequestBody String requestBody, HttpServletResponse response) {

	}
}

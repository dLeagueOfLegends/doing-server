package com.heros.doing.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.encrypt.AESCoder;
import com.heros.doing.constants.RedisConstants;
import com.heros.doing.model.UserInfo;
import com.heros.doing.service.CommonService;
import com.heros.doing.service.UserService;
import com.heros.doing.utils.ServerUtil;

@Controller
@RequestMapping(value = "/do")
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommonService commonService;

	@RequestMapping(value = "gi", method = { RequestMethod.POST })
	public void register(MultipartHttpServletRequest request, HttpServletResponse response) {
		int status = 200;
		String statusText = "ok";
		JSONObject resData = null;
		MultipartFile imgFile = request.getFile("imgFile");
		String imgSelect = request.getParameter("imgSelect");
		String dataEncrypt = request.getParameter("data");
		logger.error("body, {}", dataEncrypt);
		logger.error("imgSelect, {}", imgSelect);
		try{
			String iconUrl = userService.saveUserIcon(imgFile);
			String data = AESCoder.decryptBase64ToUtf8(dataEncrypt, AESCoder.defaultPassword);
			logger.error("data, {}", data);
			if(data == null){
				status = 401;
				statusText = "请求参数错误!";
			}else{
				JSONObject dataJson = JSON.parseObject(data);
				logger.error("dataJson, {}", dataJson);
				UserInfo userInfo = userService.createUser(dataJson);
				if(userInfo == null){
					status = 508;
					statusText = "创建用户失败！";
				}else{
					userInfo.setIconUrl(iconUrl);
					if(!userService.addUserInfo(userInfo)){
						status = 508;
						statusText = "创建用户失败！"; 
					}else{
						resData = new JSONObject();
						resData.put("userId", userInfo.getUserId());
						resData.put("password", userInfo.getPassword());
						resData.put("token", commonService.getToken(userInfo.getUserId()));
						resData.put("expire", RedisConstants.TOKEN_EXPIRE);
					}
				}
			}
		}catch(Exception e){
			logger.error("register eror, {}", e);
		}
		JSONObject res = ServerUtil.genResJson(status, statusText, resData);
		this.printNoCache(response, res.toJSONString());
	}
	
	@RequestMapping(value = "ke", method = { RequestMethod.POST })
	public void getToken(@RequestBody String requestBody, HttpServletResponse response) {
		int status = 200;
		String statusText = "ok";
		JSONObject resData = null;
		try{
			logger.error("body, {}", requestBody);
			String data = AESCoder.decryptBase64ToUtf8(requestBody, AESCoder.defaultPassword);
			logger.error("data, {}", data);
			if(data == null){
				status = 401;
				statusText = "请求参数错误!";
			}else{
				JSONObject dataJson = JSON.parseObject(data);
				String userId = dataJson.getString("userId");
				if(userId == null){
					status = 401;
					statusText = "请求参数错误!";
				}else{
					String token = commonService.getToken(dataJson.getString("userId"));
					resData = new JSONObject();
					resData.put("token", token);
					resData.put("expire", RedisConstants.TOKEN_EXPIRE);
				}
			}
		}catch(Exception e){
			logger.error("getToken eror, {}", e);
		}
		JSONObject res = ServerUtil.genResJson(status, statusText, resData);
		this.printNoCache(response, res.toJSONString());
	}
	
}

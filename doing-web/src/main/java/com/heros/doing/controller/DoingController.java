package com.heros.doing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.utils.StringUtil;
import com.heros.doing.model.Doing;
import com.heros.doing.service.CommonService;
import com.heros.doing.service.DoingService;
import com.heros.doing.utils.ResponseUtil;
import com.heros.doing.utils.ServerUtil;

@Controller
@RequestMapping(value = "doing")
public class DoingController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DoingController.class); 
	@Autowired
	CommonService commonService;
	@Autowired
	DoingService doingService;
	
	@RequestMapping(value = "pub", method = { RequestMethod.POST })
	public void publicDoing(MultipartHttpServletRequest request, HttpServletResponse response, String userId, String message, String device, String position, String token){
		logger.debug("publicDoing, {}, {}, {}, {}, {}", token, message, device, position, token);
		JSONObject resData = null;
		try{
			int imgCount = StringUtil.getIntValue(request.getParameter("imgCount"));
			if(!commonService.checkToken(token)){
				ResponseUtil.responseLackParams(response);
				return;
			}else{
				Doing doing = new Doing();
				doing.setContent(message);
				doing.setDevice(device);
				doing.setImgList(doingService.saveDoingImgs(request, imgCount));
				doing.setUserId(userId);
				doing.setPosition(position);
				doing.setPublishTime(System.currentTimeMillis());
				if(!doingService.addDoing(doing)){
					logger.error("publicDoing save doing error.");
					ResponseUtil.responseOptError(response);
					return;
				}
			}
		}catch(Exception e){
			logger.error("publicDoing error, {}", e);
			ResponseUtil.responseSysError(response);
			return;
		}
		ResponseUtil.responseOK(response, resData);
	}
	
	@RequestMapping(value = "/global/list", method = { RequestMethod.GET })
	public void getGlobalNewDoing(HttpServletRequest request, HttpServletResponse response, @RequestParam String userId, @RequestParam String token){
		logger.debug("getGlobalNewDoing, {}, {}", token, userId);
		try{
			if(!commonService.checkToken(token)){
				ResponseUtil.responseLackParams(response);
				return;
			}else{
				JSONObject resData = new JSONObject();
				resData.put("allCount", 5);
				JSONArray list = new JSONArray();
				for(int i = 0; i < 5; i++){
					JSONObject obj = new JSONObject();
					JSONArray imgList = new JSONArray();
					imgList.add("http://preview.quanjing.com/chineseview055/east-ep-a71-1370571.jpg");
					imgList.add("http://preview.quanjing.com/chineseview055/east-ep-a21-1375302.jpg");
					obj.put("message", "message");
					obj.put("device", "iphone");
					obj.put("position", "朝阳区");
					obj.put("imgCount", 2);
					obj.put("imgList", imgList);
					JSONObject user = new JSONObject();
					user.put("userId", 123);
					user.put("nickName", "哈哈的笑");
					user.put("sex", 1);
					user.put("age", 21);
					user.put("occupation", "程序猿");
					obj.put("user", user);
					list.add(obj);
				}
				resData.put("list", list);
				ResponseUtil.responseOK(response, resData);
			}
		}catch(Exception e){
			logger.error("publicDoing error, {}", e);
			ResponseUtil.responseSysError(response);
			return;
		}
	}
	
	@RequestMapping(value = "/fit/list", method = { RequestMethod.GET })
	public void getFitDoing(HttpServletRequest request, HttpServletResponse response, @RequestParam String doingId, @RequestParam String token){
		logger.debug("getFitDoing, {}, {}", token, doingId);
		try{
			if(!commonService.checkToken(token)){
				ResponseUtil.responseLackParams(response);
				return;
			}else{
				JSONObject resData = new JSONObject();
				resData.put("allCount", 5);
				JSONArray list = new JSONArray();
				for(int i = 0; i < 5; i++){
					JSONObject obj = new JSONObject();
					JSONArray imgList = new JSONArray();
					imgList.add("http://preview.quanjing.com/chineseview055/east-ep-a71-1370571.jpg");
					imgList.add("http://preview.quanjing.com/chineseview055/east-ep-a21-1375302.jpg");
					obj.put("message", "message");
					obj.put("doingId", "123" + i);
					JSONObject user = new JSONObject();
					user.put("userId", 123);
					user.put("nickName", "哈哈的笑");
					user.put("sex", 1);
					user.put("age", 21);
					user.put("occupation", "程序猿");
					obj.put("user", user);
					list.add(obj);
				}
				resData.put("list", list);
				ResponseUtil.responseOK(response, resData);
			}
		}catch(Exception e){
			logger.error("publicDoing error, {}", e);
			ResponseUtil.responseSysError(response);
			return;
		}
	}
	
}

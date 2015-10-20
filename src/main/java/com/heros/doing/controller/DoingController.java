package com.heros.doing.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
//		String userId = request.getParameter("userId");
//		String message = request.getParameter("message");
//		String position = request.getParameter("position");
//		String token = request.getParameter("token");
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
	
}

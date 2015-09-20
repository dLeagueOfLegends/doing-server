package com.heros.doing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dminor.baselib.jedis.impl.SRedis;

@Controller
public class HelloController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	SRedis redis;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(HttpServletRequest request, HttpServletResponse response){
		logger.error("++++++++++++==");
		redis.set("test11", "123");
		logger.error("++++++++++++==11, {}", redis.get("test11"));
		this.printNoCache(response, "hello.");
	}
}

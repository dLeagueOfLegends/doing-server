package com.heros.doing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void hello(HttpServletRequest request, HttpServletResponse response){
		logger.error("++++++++++++==");
		this.printNoCache(response, "hello.");
	}
}

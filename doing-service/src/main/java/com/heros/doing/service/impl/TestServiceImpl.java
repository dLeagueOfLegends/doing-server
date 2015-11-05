package com.heros.doing.service.impl;

import org.springframework.stereotype.Service;

import com.heros.doing.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{
	
	public void hello(){
		System.out.println("++++, hello");
	}
	
}

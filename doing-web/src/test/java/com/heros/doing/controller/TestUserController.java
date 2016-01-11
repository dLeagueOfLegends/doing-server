package com.heros.doing.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dminor.baselib.utils.HttpUtil;
import com.dminor.baselib.utils.JsonUtil;

public class TestUserController {
	
	@Test
	public void TestRegister(){
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> fileMap = new HashMap<String, String>();
		params.put("imgSelect", "0");
		params.put("data", "{\"nickName\" : \"张三\",\"sex\" : 1,\"age\" : 21,\"occupation\" : \"学生\",\"deviceCode\" : \"abcdefg\"}");
		fileMap.put("imgFile", "D:\\test.jpg");
		System.out.println(HttpUtil.formUpload("http://127.0.0.1:3001/do/gi", params, fileMap));
	}
	
	@Test
	public void TestGetToken(){
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> fileMap = new HashMap<String, String>();
		params.put("userId", "userId");
		params.put("token", "tokenId");
		System.out.println(HttpUtil.Get("http://127.0.0.1:3001/do/ke", "data=" + JsonUtil.ObjectToString(params)));
	}
	
	@Test
	public void TestSaveUserInfo(){
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> fileMap = new HashMap<String, String>();
		params.put("token", "token");
		params.put("user", "{\"nickName\" : \"张si\",\"sex\" : 1,\"age\" : 21,\"occupation\" : \"学生\",\"userId\" : \"82603a49\"}");
		System.out.println(HttpUtil.formUpload("http://127.0.0.1:3001/userinfo/save", params, fileMap));
	}

	@Test
	public void TestPublishDoing(){
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("img1", "D:\\test.jpg");
		fileMap.put("img2", "D:\\test1.jpg");
		params.put("imgCount", "2");
		params.put("userId", "82603a49");
		params.put("token", "82603a49");
		params.put("message", "第一条doing");
		params.put("position", "北京市");
		params.put("device", "iphone5s");
		System.out.println(HttpUtil.formUpload("http://127.0.0.1:3001/doing/pub", params, fileMap));
	}
}

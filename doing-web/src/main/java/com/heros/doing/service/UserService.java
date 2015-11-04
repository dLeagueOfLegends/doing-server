package com.heros.doing.service;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.heros.doing.model.UserInfo;

public interface UserService {
	public UserInfo createUser(JSONObject postJson);

	boolean addUserInfo(UserInfo userInfo);

	String saveUserIcon(MultipartFile iconFile);

	UserInfo getUserInfoById(String userId);

	boolean setUserInfo(UserInfo userInfo);
}

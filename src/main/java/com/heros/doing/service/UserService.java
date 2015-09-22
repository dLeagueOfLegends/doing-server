package com.heros.doing.service;

import com.alibaba.fastjson.JSONObject;
import com.heros.doing.model.UserInfo;

public interface UserService {
	public UserInfo createUser(JSONObject postJson);

	boolean addUserInfo(UserInfo userInfo);
}

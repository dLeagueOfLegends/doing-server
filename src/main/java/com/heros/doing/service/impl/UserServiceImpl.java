package com.heros.doing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.jedis.impl.SRedis;
import com.dminor.baselib.utils.FileUtil;
import com.heros.doing.constants.RedisConstants;
import com.heros.doing.dao.UserInfoDao;
import com.heros.doing.model.UserInfo;
import com.heros.doing.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SRedis redis;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	public boolean checkRegisterParams(JSONObject postJson){
		if(postJson.containsKey("nickName"));
		return true;
	}
	
	@Override
	public UserInfo createUser(JSONObject postJson){
		if(postJson == null){
			return null;
		}
		UserInfo userInfo = new UserInfo();
		String deviceCode = postJson.getString("deviceCode");
		Long registerTime = System.currentTimeMillis();
		logger.error("time, {}", registerTime);
		String md5 = FileUtil.getMD5(deviceCode + registerTime);
		if(md5 == null){
			return null;
		}
		String userId = md5.substring(0, 7) + redis.incr(RedisConstants.USERID_GEN_INCR);
		String password = md5.substring(8, 20);
		
		userInfo.setAge(postJson.getIntValue("age"));
		userInfo.setDeviceCode(deviceCode);
		userInfo.setIconUrl("http://p1.gexing.com/G1/M00/AC/85/rBACFFPzVnXhKBDLAACQ503PAK8037.jpg");
		userInfo.setLastLoginTime(registerTime);
		userInfo.setNickName(postJson.getString("nickName"));
		userInfo.setOccupation(postJson.getString("occupation"));
		userInfo.setPassword(password);
		userInfo.setRegisterTime(registerTime);
		userInfo.setSex(postJson.getIntValue("sex"));
		userInfo.setUserId(userId);
		return userInfo;
	}
	
	@Override
	public boolean addUserInfo(UserInfo userInfo){
		userInfoDao.addUserInfo(userInfo);
		return true;
	}

}

package com.heros.doing.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.jedis.impl.SRedis;
import com.dminor.baselib.utils.FileUtil;
import com.heros.doing.constants.RedisConstants;
import com.heros.doing.constants.ServerConstants;
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
		userInfoDao.save(userInfo);
		return true;
	}
	
	@Override
	@Transactional
	public UserInfo getUserInfoById(String userId){
		List<UserInfo> list = userInfoDao.list("id", false, "userId", userId);
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
	}
	
	@Override
	public String saveUserIcon(MultipartFile iconFile){
		String fileName = System.currentTimeMillis() + ".jpg";
		try {
			File iconDir = new File(ServerConstants.USER_ICON_DIR);
			if(!iconDir.exists()){
				iconDir.mkdirs();
			}
			iconFile.transferTo(new File(ServerConstants.USER_ICON_DIR + "/" + fileName));
		} catch (IllegalStateException e) {
			logger.error("saveUserIcon error1, {}", e);
		} catch (IOException e) {
			logger.error("saveUserIcon error2, {}", e);
		}
		return ServerConstants.USER_ICON_URL + "/" + fileName;
	}

}

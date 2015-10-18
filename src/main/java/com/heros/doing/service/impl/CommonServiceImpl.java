package com.heros.doing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dminor.baselib.encrypt.AESCoder;
import com.dminor.baselib.jedis.impl.SRedis;
import com.heros.doing.constants.RedisConstants;
import com.heros.doing.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private SRedis redis;
	
	@Override
	public String getToken(String userId){
		String token = AESCoder.encryptToBase64(userId + System.currentTimeMillis(), AESCoder.defaultPassword);
		if(token != null && token.length() > 32){
			token = token.substring(0, 32);
		}
		redis.setEx(RedisConstants.TOKEN_KEY + token, RedisConstants.TOKEN_EXPIRE + 100, "");
		return token;
	}
	
	@Override
	public boolean checkToken(String token){
		return true;
//		if(token == null || token.length() < 15){
//			return false;
//		}
//		return redis.exists(RedisConstants.TOKEN_KEY + token);
	}
}

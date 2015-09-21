package com.heros.doing.dao.impl;

import org.springframework.stereotype.Repository;

import com.dminor.baselib.dao.CommonDao;
import com.heros.doing.dao.UserInfoDao;
import com.heros.doing.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends CommonDao implements UserInfoDao{

	@Override
	public void addUserInfo(UserInfo userInfo){
		this.save(userInfo);
	}
}

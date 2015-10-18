package com.heros.doing.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dminor.baselib.dao.CommonDao;
import com.dminor.baselib.dao.Dao;
import com.heros.doing.dao.UserInfoDao;
import com.heros.doing.model.UserInfo;

//@Repository("userInfoDao")
public class UserInfoDaoImpl extends Dao<UserInfo>{

//	@Override
//	public void addUserInfo(UserInfo userInfo){
//		this.save(userInfo);
//	}
//	
//    @Override
//    public UserInfo getUserInfoByUserId(String userId) {
//        List<UserInfo> list = this.list("id", false, "userId", userId);
//        if(list != null && !list.isEmpty()){
//            return list.get(0);
//        }
//        return null;
//    }
}

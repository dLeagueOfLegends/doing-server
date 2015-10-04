package com.heros.doing.dao.impl;

import org.springframework.stereotype.Repository;

import com.dminor.baselib.dao.CommonDao;
import com.heros.doing.dao.DoingDao;
import com.heros.doing.model.Doing;

@Repository("doingDao")
public class DoingDaoImpl extends CommonDao implements DoingDao{
	
	@Override
	public boolean addDoing(Doing doing){
		return this.save(doing);
	}
}

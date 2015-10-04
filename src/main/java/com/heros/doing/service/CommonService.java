package com.heros.doing.service;

public interface CommonService {

	String getToken(String userId);

	boolean checkToken(String token);

}

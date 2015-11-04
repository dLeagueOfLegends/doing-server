package com.heros.doing.utils;

import com.alibaba.fastjson.JSONObject;

public class ServerUtil {
	
	public static JSONObject genResJson(int status, String statusText, JSONObject resData){
		JSONObject res = new JSONObject();
		res.put("status", status);
		res.put("statusText", statusText);
		res.put("data", resData);
		return res;
	}
}

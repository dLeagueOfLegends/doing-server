package com.heros.doing.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dminor.baselib.utils.HttpUtil;

public class TestUserController {
	
	@Test
	public void TestRegister(){
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String> fileMap = new HashMap<String, String>();
		params.put("imgSelect", "0");
		params.put("data", "x7MGtny5nFDefAgTaRcckwhL3HbDlPq/gNwKZ77FMT22OWQAvB0Z3CK66askkYrpUb0LUB3jUJptsc9IMaRFPLZdT5PqpAfGxtXQwKU2SkToiXLBuOXpDVs37s73EpiEmRDsuaCggEcRvQ3aKcFzOg==");
		fileMap.put("imgFile", "D:\\test.jpg");
		System.out.println(HttpUtil.formUpload("http://127.0.0.1:3500/do/gi", params, fileMap));
	}

}

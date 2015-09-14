package com.heros.doing.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;

public class BaseController {
    /**
     * @param response
     * @param result
     */
    public void printNoCache(HttpServletResponse response, String result) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().print(result);
            response.flushBuffer();
        } catch (IOException e) {
            System.out.println("print result error" + e);
        }
    }
    
    public void sendResponse(HttpServletResponse response, int status, Object data){
    	JSONObject res = new JSONObject();
    	res.put("status", status);
    	res.put("data", data);
    	printNoCache(response, res.toJSONString());
    }
}
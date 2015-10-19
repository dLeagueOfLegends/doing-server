package com.heros.doing.controller;

import java.io.IOException;
import java.io.OutputStream;

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
        OutputStream out = null;
        try {
        	out = response.getOutputStream();
            byte[] bytes = result.getBytes( "utf-8" );
            response.setStatus( 200 );
            response.setContentLength( bytes.length );
            response.setCharacterEncoding( "utf-8" );
            response.setContentType( "application/json; charset=UTF-8" );
            // response.setDateHeader("Expires", 0);
            // response.setHeader("Pragma", "no-cache");
            // // HTTP 1.1
            // response.setHeader("Cache-Control", "No-cache");
            out.write( bytes );
            out.flush();
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
package com.heros.doing.utils;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
/**
 * 用于请求回复的工具类
 * @author wenlinli
 *
 */
public class ResponseUtil {
	private static final int STATUS_OK = 200;
	private static final int STATUS_LACK_PARAMS = 401;
	private static final int STATUS_SYS_ERROR = 501;
	private static final int STATUS_OPT_ERROR = 502;
	
	public static void responseNoCache(HttpServletResponse response, String result, String callback) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        OutputStream out = null;
        if(callback != null){
        	result = callback + "(" + result + ");";
        }
        try {
        	out = response.getOutputStream();
            byte[] bytes = result.getBytes( "utf-8" );
            response.setStatus( 200 );
            response.setContentLength( bytes.length );
            response.setCharacterEncoding( "utf-8" );
            response.setContentType( "application/json; charset=UTF-8" );
            out.write( bytes );
            out.flush();
        } catch (IOException e) {
            System.out.println("print result error" + e);
        }
    }
    
    public static void responseLackParams(HttpServletResponse response, String callback){
    	JSONObject res = new JSONObject();
    	res.put("status", STATUS_LACK_PARAMS);
    	res.put("statusText", "param error.");
    	res.put("data", "");
    	responseNoCache(response, res.toJSONString(), callback);
    }
    
    public static void responseSysError(HttpServletResponse response, String callback){
    	JSONObject res = new JSONObject();
    	res.put("status", STATUS_SYS_ERROR);
    	res.put("statusText", "server error.");
    	res.put("data", "");
    	responseNoCache(response, res.toJSONString(), callback);
    }
    
    public static void responseOptError(HttpServletResponse response, String callback){
    	JSONObject res = new JSONObject();
    	res.put("status", STATUS_OPT_ERROR);
    	res.put("statusText", "operate failed.");
    	res.put("data", "");
    	responseNoCache(response, res.toJSONString(), callback);
    }
    
    public static void responseOK(HttpServletResponse response, Object data, String callback){
    	JSONObject res = new JSONObject();
    	res.put("status", STATUS_OK);
    	res.put("statusText", "ok");
    	res.put("data", data);
    	responseNoCache(response, res.toJSONString(), callback);
    }
    
    public static void responseLackParams(HttpServletResponse response){
    	responseLackParams(response, null);
    }
    
    public static void responseSysError(HttpServletResponse response){
    	
    	responseSysError(response, null);
    }
    
    public static void responseOptError(HttpServletResponse response){
    	responseOptError(response, null);
    }
    
    public static void responseOK(HttpServletResponse response, Object data){
    	responseOK(response, data, null);
    }
}

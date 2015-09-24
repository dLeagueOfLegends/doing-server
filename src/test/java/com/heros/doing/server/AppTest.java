package com.heros.doing.server;

import com.alibaba.fastjson.JSONObject;
import com.dminor.baselib.encrypt.AESCoder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public static void main(String[] argvs){
    	JSONObject obj = new JSONObject();
    	obj.put("nickName", "dminor");
    	obj.put("sex", 1);
    	obj.put("age", 21);
    	obj.put("occupation", "学生");
    	obj.put("deviceCode", "a8f5f167f44f4964e6c998dee827110c");
    	
    	JSONObject obj1 = new JSONObject();
    	obj1.put("userId", "userId");
    	obj1.put("password", "password");
    	System.out.println(AESCoder.encryptToBase64(obj.toJSONString(), AESCoder.defaultPassword));
    	System.out.println(AESCoder.encryptToBase64(obj1.toJSONString(), AESCoder.defaultPassword));
    }
}

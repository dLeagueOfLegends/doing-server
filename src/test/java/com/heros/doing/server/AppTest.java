package com.heros.doing.server;

import java.io.UnsupportedEncodingException;

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
    
    
    public static void main(String[] argvs) throws Exception{
    	JSONObject obj = new JSONObject();
    	obj.put("nickName", "dminor");
    	obj.put("sex", 1);
    	obj.put("age", 21);
    	obj.put("occupation", "学生");
    	obj.put("deviceCode", "a8f5f167f44f4964e6c998dee827110c");
    	
    	JSONObject obj1 = new JSONObject();
    	obj1.put("userId", "userId");
    	obj1.put("password", "password");
    	String aa = "0v/o5kZCHVJhO0L1EOJhYhBZDcgQ5Vf0a0zp38npNHXCw7w457EnAMfL0yqMZzir3ayCVLib9xH1UKJO/lEk0qVdc5zmHEYEPJT/2ZBg/vyryx37U47WqF2Ri7li2ePu64xqhiFaExPOVf3o2CuF+I3KviwCONoT3VOBuLhWlIw=";
//    	String res = null;
//		try {
//			res = new String(AESCoder.encrypt(obj1.toJSONString(), AESCoder.defaultPassword), "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println("----, " + AESCoder.encryptToBase64("abcdef", AESCoder.defaultPassword));
    	System.out.println("----, " + new String(AESCoder.decryptBASE64("heXsM2UroVjMGchikGOh/g==")));
    	System.out.println("---11, " + new String(AESCoder.decryptBASE64("BAm7+JGfYvzqNPlHdlMZJg==")));
//    	try {
//			System.out.println("111" + AESCoder.decrypt(AESCoder.decryptBASE64(aa), AESCoder.defaultPassword));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(AESCoder.decrypt(res.getBytes(), AESCoder.defaultPassword));
//    	String tt = AESCoder.encryptToBase64(obj1.toJSONString(), AESCoder.defaultPassword);
//    	System.out.println(tt);
//    	System.out.println(AESCoder.decryptBase64ToUtf8(tt, AESCoder.defaultPassword));
//    	System.out.println(AESCoder.encryptToBase64(obj1.toJSONString(), AESCoder.defaultPassword));
    }
}

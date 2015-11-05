package com.heros.doing.service;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class DoingServer {
	
    /**
     * start  server.
     */
    public void start() {
        System.out.println("===> StarfansServer Start Begin");
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        appContext.start();
        System.out.println("===> StarfansServer Start Successful");
    }

    /**
     * exit system
     */
    public void exit() {
        System.exit(0);
    }

    public void run() throws InterruptedException {
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }

    public static void main(String[] args) throws IOException {
    	
        Resource res = new ClassPathResource("applicationConfig.properties");
        if (res.exists()) {
            Properties pro = PropertiesLoaderUtils.loadProperties(res);
            System.setProperty("spring.profiles.default", pro.getProperty("spring.profiles.default"));
        } else {
            System.setProperty("spring.profiles.default", "dev");// 默认加载开发环境
        }
        System.out.println("Spring profile is " + System.getProperty("spring.profiles.default"));

        DoingServer server = new DoingServer();
        server.start();
        try {
            server.run();
        } catch (InterruptedException e) {
        	System.out.println("StarfansServer  run error " + e);
        }
    }
}

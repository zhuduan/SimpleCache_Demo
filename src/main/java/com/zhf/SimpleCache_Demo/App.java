package com.zhf.SimpleCache_Demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.zhuduan.cache.SimpleCache;

/**
 * Hello world!
 * 使用了AOP Cache的Demo
 *
 */
@Service
public class App{	
	
    public static void main( String[] args ) throws InterruptedException, NoSuchMethodException, SecurityException{
		@SuppressWarnings("resource")
		AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		App app = (App) cxt.getBean(App.class);  
		
		System.out.println("start!");
		for(int i=0;i<6;i++){
			System.out.println(i+": "+app.helloWorld());
			Thread.sleep(1000);
		}
    }
    
    @SimpleCache(expire=2)
    public String helloWorld(){
    	return "helloWorld";
    }
    
}

package com.zhf.SimpleCache_Demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.zhuduan.cache.SimpleCache;
import org.zhuduan.cache.SimpleCacheAspect;

/**
 * Hello world!
 *
 */
@Service
public class App{	
	
    public static void main( String[] args ) throws InterruptedException{
		@SuppressWarnings("resource")
		AbstractApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		App app = (App) cxt.getBean(App.class);  
		
		SimpleCacheAspect aspect = cxt.getBean(SimpleCacheAspect.class);
		System.out.println("local: " + aspect.isUseLocalCache());
		
		
		for(Annotation anno : SimpleCacheAspect.class.getAnnotations()){
			System.out.println(anno.annotationType() + "," + anno.toString());
		}
		
		
		System.out.println("start!");
		for(int i=0;i<6;i++){
			System.out.println(i+": "+app.helloWorld());
			System.out.println(i+": "+app.helloWorld_NoCache());
			Thread.sleep(1000);
		}
    }
    
    @SimpleCache(expire=2)
    private String helloWorld(){
    	return "helloWorld";
    }
    
    private String helloWorld_NoCache(){
    	return "helloWorld no cache";
    }
}

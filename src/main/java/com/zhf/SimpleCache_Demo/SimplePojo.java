package com.zhf.SimpleCache_Demo;

/**
 * 一个用于测试的简单类
 * 
 * @author	zhuhaifeng
 * @date	2017年3月16日
 *
 */
public class SimplePojo {

	private Double id;
	
	private String name;
	
	/**
	 * 默认的构造器（fastJson反序列化的时候需要）
	 * 
	 */
	SimplePojo(){
	}
	
	SimplePojo(Double idValue){
		this.id = idValue;
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return ("I am a SimplePojo-"+id);
	}
}

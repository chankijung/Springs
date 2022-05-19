package com.care.root4;

import org.springframework.context.support.GenericXmlApplicationContext;

public interface Car {
	public String path="classpath:car.xml";
	public GenericXmlApplicationContext ctx=
			new GenericXmlApplicationContext(path);
	
	public void speed();
}

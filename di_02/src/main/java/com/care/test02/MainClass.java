package com.care.test02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test02.xml";
		GenericXmlApplicationContext ctx=
				new GenericXmlApplicationContext(path);
		
		SaveClass sc = ctx.getBean("sc", SaveClass.class);
		sc.printClass();
	}
}

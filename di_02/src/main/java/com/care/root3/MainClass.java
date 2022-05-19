package com.care.root3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.root2.STBean;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test.xml";
		
		GenericXmlApplicationContext ctx=
				new GenericXmlApplicationContext(path);
		
		PrintBean pb = ctx.getBean("pb", PrintBean.class);

	
		pb.printString();
		
	}
}

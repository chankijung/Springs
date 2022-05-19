package com.care.root2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//STBean stb = new STBean();
		//stb.setSt(new Student());
			String path="classpath:applicationST.xml";
			GenericXmlApplicationContext ctx=
					new GenericXmlApplicationContext(path);
			
			STBean stb = ctx.getBean("stb", STBean.class);
			
//			stb.setName("홍길동");
//		
//			stb.setAge(20);
		
		
			stb.nameP(); stb.ageP();
	}
}

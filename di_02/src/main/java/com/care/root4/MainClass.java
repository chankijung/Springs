package com.care.root4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		
		//Car car = new CarService01();
		Car car =Car.ctx.getBean("car", Car.class);
		
		System.out.println("메인에서 달립니다");
		car.speed();
		
		Test t = new Test();
		t.test();
	}
}

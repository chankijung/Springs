package com.care.root4;

public class Test {
	public void test() {
		Car car =Car.ctx.getBean("car", Car.class);
		System.out.println("Test에서 달립니다!!");
		car.speed();
		
		
	}
}

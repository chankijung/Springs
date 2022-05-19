package com.care.test02;

public class PrintClass {
	public void printFunc(int num1, String op, int num2, int result) {
		OperationClass opc = new OperationClass();
		int rs= opc.operation(num1, num2, op);
		System.out.println("결과 : "+rs);
		
	}
}

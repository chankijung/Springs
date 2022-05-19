package com.care.test02;

import java.util.Scanner;

public class OperationClass {
	public int operation(int num1, int num2, String op) {
		Scanner input = new Scanner(System.in);
		System.out.print("num1 :");
		num1 =input.nextInt();
		System.out.print("num2 :");
		num2 = input.nextInt();
		System.out.print(" op :");
		op = input.next();
		int result;
		if(op.equals("+")) {
			result= num1+num2; 
			
		}else if(op.equals("-")) {
			result= num1-num2; 
		
		}else if(op.equals("*")) {
			result= num1*num2; 
		}else {
			result= num1/num2; 
		}
		return result;
	}
}

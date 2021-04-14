package com.capg.Lab9;

import java.util.function.BiFunction;  

public class Ex4MethodRefernce { 
	public static void main(String[] args) 
	{  
		BiFunction<Integer, Integer, Integer> adder = Addition::add;  
		int result = adder.apply(10, 20);  
		System.out.println(result);  
	}  
}  
class Addition {
	
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	private int a;
	private int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	static int add(int a ,int b) {
		return a+b;
	}
}
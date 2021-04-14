package com.capg.Lab9;

import java.util.function.BiFunction;

public class Ex1Power {

	public static void main(String[] args) {
		BiFunction<Integer,Integer,Integer> pow1= (x,y)-> (int)Math.pow(x, y);
		int power=pow1.apply(5, 3);
		System.out.println(power);
		
	}

}
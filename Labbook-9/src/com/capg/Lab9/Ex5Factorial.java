package com.capg.Lab9;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Ex5Factorial {
	
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> fac = Factorial::calFact; //method referencing
		int n=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of which you want factorial");
		int facValue = fac.apply(sc.nextInt(), n);  
		sc.close();
		System.out.println("Product of given number is: "+facValue);
		
	}

}
class Factorial{
	
	static int calFact(int m,int n) {
		
		for(int i=m;i>=1;i--) {
			n=n*i;
		}
		return n;
	}
}
package com.capg.Lab1;
import java.util.Scanner;

public class Ex1SumoftheCubes {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n,sum=0;
	        System.out.println("Enter the value of n");
	        n=sc.nextInt();
	        for(int i=1;i<=n;i++)
	        	sum=sum+(i*i*i);
	        System.out.println("The sum of first " + n + " cube numbers is " + sum);
	    }

}
package com.cg.eis.exceptionex1;
import java.util.Scanner;

class AgeExc extends Exception {
		 

	 
	 public AgeExc(String str) {
	  System.out.println(str);
	 }
	}
	public class AgeException{
	 
	 public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
	  System.out.print("Enter ur age :: ");
	  int age = s.nextInt();
	  
	  try {
	   if(age < 18) 
	    throw new AgeExc("Invalid age");
	   else
	    System.out.println("Valid age");
	  }
	  catch (AgeExc a) {
	   System.out.println(a);
	  }
	 }
	}



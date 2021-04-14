package com.capg.Lab9;

import java.util.Scanner;

public class Ex2AddSpace {

	public static void main(String[] args) {
		
	AddSpace as= s->{
		
		String str=s.replace(""," ").trim();
		
		return str;
	};
	
	Scanner sc= new Scanner(System.in);
	
	System.out.println("Enter string without spaces");
	String s= sc.next();
	sc.close();
	String str= as.addSpace(s);
	System.out.println(str);
		
		
	}

}
interface AddSpace{
	
	String addSpace(String str);
	
}
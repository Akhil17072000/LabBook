package com.capg.Lab3;

import java.util.Scanner;

public class Ex2MirrorString {
	
	public static String getImage(String s) {
		
		StringBuffer sb= new StringBuffer();
		sb.append(s);
		sb.reverse();
		String r=sb.toString();
		
		return r;
	}


	public static void main(String[] args) {
			
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String m=getImage(s);
		System.out.println(s+"|"+m);
	}

	
}
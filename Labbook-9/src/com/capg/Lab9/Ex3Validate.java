package com.capg.Lab9;

import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class Ex3Validate {

	public static void main(String[] args) {
	
		BiPredicate<String, String> prd= (x,y)->{
			boolean userNamePattern=Pattern.matches("[a-zA-Z0-9]{6,12}", x);
			if(!userNamePattern) {
				return false; 
			}	
			boolean passwordPattern=Pattern.matches("[a-zA-Z0-9]{8,14}", y);
			if(!passwordPattern) {
				return false; 
			}			
			return true;
			
		};
		boolean validateCredentials=prd.test("Akhil@123","Arpit1234");
		System.out.println(validateCredentials);

	}

}
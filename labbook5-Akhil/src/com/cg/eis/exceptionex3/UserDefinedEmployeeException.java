package com.cg.eis.exceptionex3;

import java.util.Scanner;

public class UserDefinedEmployeeException {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int s= sc.nextInt();
		
		sc.close();
		
		try {
			salary(s);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}

	static void salary(int salary) throws EmployeeException {
		
		if(salary<3000) {
			EmployeeException e= new EmployeeException();// will replace this with user defined Exception
			throw e;
		}
		else {
			System.out.println("Salary is greater than 3000...");
		}
	}
}
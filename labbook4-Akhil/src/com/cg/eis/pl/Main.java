package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Emp Id");
		int empId=sc.nextInt();
		System.out.println("Enter Emp Name");
		String empName=sc.next();
		System.out.println("Enter Emp Salary");
		double empSalary=sc.nextDouble();
		System.out.println("Enter Emp Designation");
		System.out.println("Valid Designation are: \n"
				+ "Associate \n"
				+ "Programmer \n"
				+ "Manager \n"
				+ "Clerk");
		String empDesignation=sc.next();
		sc.close();
		
		EmployeeService empSer= new EmployeeServiceImpl();
		
		String empInsuranceScheme = null;
		Employee emp = empSer.getEmployeeDetails(empId, empName, empSalary,empDesignation,empInsuranceScheme);
		
		empSer.findInsuranceScheme(emp);
		
		empSer.displayAllDetails(emp);
	}

}
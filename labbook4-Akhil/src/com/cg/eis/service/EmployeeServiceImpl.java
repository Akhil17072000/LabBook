package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	public Employee getEmployeeDetails(int id, String name, double salary, String designation, String InsuranceScheme) {
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDesignation(designation);
		emp.setInsuranceScheme(InsuranceScheme);
		return emp;
	}

	@Override
	public void findInsuranceScheme(Employee emp) {
		if(emp.getSalary()>=5000 && emp.getSalary()<=20000 )
		{	
			if(emp.getDesignation().equals("Associate")) 
			emp.setInsuranceScheme("Scheme C");
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<=40000)
		{
			if(emp.getDesignation().equals("Programmer")) 
			emp.setInsuranceScheme("Scheme B");
		}else if(emp.getSalary()>40000) 
		{
			if(emp.getDesignation().equals("Manager"))
			emp.setInsuranceScheme("Scheme A");
		}else if(emp.getSalary()<5000)
		{
			if(emp.getDesignation().equals("Clerk"))
			emp.setInsuranceScheme("No Scheme");
		}
	}

	@Override
	public void displayAllDetails(Employee emp) {
		
		System.out.println("Employee Id :"+ emp.getId());
		System.out.println("Employee Name :"+ emp.getName());
		System.out.println("Employee Salary :"+ emp.getSalary());
		System.out.println("Employee Designation :"+ emp.getDesignation());
		System.out.println("Employee Insurance Scheme :"+ emp.getInsuranceScheme());
		
		
			}

}
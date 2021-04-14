package com.capg.Lab9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

@FunctionalInterface
interface EmployeeService1{
	double sumSalary(ArrayList<Employee> a);
}

@FunctionalInterface
interface EmployeeService2{
	void NoDepartmentEmployee(ArrayList<Employee> a);
}

@FunctionalInterface
interface EmployeeService3{
	void NoEmployeeDepartment(ArrayList<Employee> a);
}
@FunctionalInterface
interface EmployeeService4{
	void FridayEmployee(ArrayList<Employee> a);
}
@FunctionalInterface
interface EmployeeService5{
	void incrementedSalary(ArrayList<Employee> a);
}
@FunctionalInterface
interface EmployeeService6{
	void EmployeeWithoutManager(ArrayList<Employee> a);
}


public class EmployeeService {
	
	static double sumSalary(ArrayList<Employee> a) {
		
		double sumSal=0.0;
		Iterator<Employee> i= a.iterator();
		while(i.hasNext()) {
			Employee e= i.next();
			sumSal=sumSal+e.getSalary();
		}
		return sumSal;
	}


	public static void main(String[] args) {
		
		Department d1= new Department(303,"Documentation",0);
		Department d2= new Department(301,"Finance",201);
		Department d3=  new Department(302,"CSE",204);
		Department d4= new Department(302,"CSE",204);
		Department d5=  new Department(301,"Finance",201);

		Employee emp1= new Employee(101, "Akhil", "Kumar", "akhil08@gmail.com", "9764103424", LocalDate.of(2000, 12, 11), "Typist",20000, 0, d1 );
		Employee emp2= new Employee(102, "kamal", "Kumar", "kamalkumar@gmail.com", "9764103111", LocalDate.of(2001, 1, 11), "Cashier",30000, 201,d2 );
		Employee emp3= new Employee(103, "Ram", "Kumar", "ramkumar@gmail.com", "9764000000", LocalDate.of(2002, 2, 10), "Coder",40000, 204,d3);
		Employee emp4= new Employee(104, "karam", "Kumar", "karamkumar@gmail.com", "9760003424", LocalDate.of(2003, 9, 12), "Programmer",42000, 204,d4);
		Employee emp5= new Employee(105, "Ramu", "Kumar", "ramukumar@gmail.com", "9764435424", LocalDate.of(2004, 11, 19), "Manager",50000, 201,d5);
		
		
		ArrayList<Employee> employees= new ArrayList<>();
		employees.add(emp1);
		employees.add(emp5);
		employees.add(emp4);
		employees.add(emp2);
		employees.add(emp3);
		
		ArrayList<Department> dm= new ArrayList<>();
		dm.add(d1);
		dm.add(d2);
		dm.add(d3);
		dm.add(d4);
		dm.add(d5);
		
		EmployeeService1 es1= s1->{
			double sumSal=0.0;
			Iterator<Employee> i= s1.iterator();
			while(i.hasNext()) {
				Employee e= i.next();
				sumSal=sumSal+e.getSalary();
			}
			return sumSal;
		};
		
		double sumSalary=es1.sumSalary(employees);
		System.out.println(sumSalary);
		

		EmployeeService2 es2= s2->{
			
			s2.stream().filter(e->e.getDepartment()==null).forEach(dept->System.out.println(dept.getFirstName()+" "+dept.getLastName()));
			
		};
		es2.NoDepartmentEmployee(employees);
		
		EmployeeService3 es3= s3->{
			
			Iterator<Employee> i= s3.iterator();
			while(i.hasNext()) {
				Employee e= i.next();
				System.out.println(e.getFirstName()+" "+e.getLastName()+" "+e.getHireDate()+" "+e.getHireDate().getDayOfWeek());
			}
		};
		es3.NoEmployeeDepartment(employees);
		
		EmployeeService4 es4= s4->{
		
		s4.stream().filter(emp->emp.getHireDate().getDayOfWeek().equals("FRIDAY")).forEach(eee->System.out.println(eee.getFirstName()+" "+eee.getLastName()+" "+eee.getHireDate()));
		};
		
		es4.FridayEmployee(employees);
		
		EmployeeService5 es5= s5->{
			
		s5.stream().forEach(e5->System.out.println(e5.getFirstName()+" "+e5.getLastName()+" "+e5.getSalary()+" "+(e5.getSalary()*15/100)));
		};
			
		es5.incrementedSalary(employees);
		
		EmployeeService6 es6= s6->{
			
			s6.stream().filter(e6->e6.getManagerId()==0).forEach(dept->System.out.println(dept.getFirstName()+" "+dept.getLastName()));
			};
				
			es6.EmployeeWithoutManager(employees);
		
		
	}

}

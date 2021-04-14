package com.capg.Lab3;

import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.Scanner; 

class Ex9DateDifference { 
	
	static void findDifference(String start_date, 
				String end_date) 
	{ 
		SimpleDateFormat sdf 	= new SimpleDateFormat("dd-MM-yyyy"); 
		
		try { 
			
			Date d1 = sdf.parse(start_date); 
			Date d2 = sdf.parse(end_date); 
			
			
			long difference_In_Days= d2.getDate() - d1.getDate(); 
			
			
			long difference_In_Years = d2.getYear() - d1.getYear(); 

			long difference_In_Months = d2.getMonth() - d1.getMonth(); 


			System.out.print( "Difference "+ "between two dates is: "); 

			System.out.println( difference_In_Years + " years, "+ difference_In_Months + " months "+ difference_In_Days + " days, "); 
		} 

		catch (ParseException e) { 
			e.printStackTrace(); 
		} 
	} 

	public static void main(String[] args) 
	{  
		Scanner sc=new Scanner(System.in);
	
		String start_date 
			= sc.nextLine(); 

		String end_date 
			= sc.nextLine(); 
		
		findDifference(start_date, end_date); 
	} 
}
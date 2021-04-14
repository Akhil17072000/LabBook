package com.LabBook6;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ex6VoteEligibilty {
		
		static ArrayList<String> votersList(HashMap<String,String> hm){
			
			ArrayList<String> a= new ArrayList<>();
			
			DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for(Entry<String, String> entry:hm.entrySet()) 
			{			
				
				LocalDate localdateofbirth= LocalDate.parse(entry.getValue(),formatter);
				LocalDate today = LocalDate.now();                          
				Period p = Period.between(localdateofbirth, today);
			
				if(p.getYears()>=18) {
					a.add(entry.getKey());
				}
		}
			return a;
}

	public static void main(String[] args) {
		
		HashMap<String,String> personData =new HashMap<>();
		System.out.println("Enter no of Person");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println("Enter Person ID and Age");
		for(int i=0; i<n;i++) {
			personData.put(sc.next(),sc.next());
		}
		sc.close();
		ArrayList<String> val = votersList(personData);
		for(String s : val){
			System.out.println(s);
		}

	}

}
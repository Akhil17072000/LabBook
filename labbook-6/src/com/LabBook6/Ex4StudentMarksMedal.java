package com.LabBook6;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex4StudentMarksMedal {
	static HashMap<String,String> getStudents(HashMap<String,Integer> students) {
		HashMap<String, String> medal = new HashMap<>(); 
		for (Map. Entry<String, Integer> entry : students.entrySet()) {
				if(entry.getValue()>=90)
					medal.put(entry.getKey(), "Gold");
				else if(entry.getValue() >=80 && entry.getValue()<90) 
					medal.put(entry.getKey(), "Silver"); 
				else if(entry.getValue() >=70 && entry.getValue()<80)
					medal.put(entry.getKey(), "Bronze");
				else 
					medal.put(entry.getKey(), null);
		}
		return medal;
			
	}

	public static void main(String[] args) {
	
		HashMap<String,Integer> studentsData =new HashMap<>();
		System.out.println("Enter no of Students");
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println("");
		for(int i=0; i<n;i++) {
			studentsData.put(sc.next(),sc.nextInt());
		}
		sc.close();
		HashMap<String,String> val = getStudents(studentsData);
		for(Map.Entry<String,String> entry : val.entrySet()){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}		
}
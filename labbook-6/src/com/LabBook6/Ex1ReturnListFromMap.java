package com.LabBook6;
import java.util.*;

public class Ex1ReturnListFromMap {
	
	static ArrayList<Integer> getValues(LinkedHashMap<Integer, Integer> hm){
		
		ArrayList<Integer> value= new ArrayList<>(hm.values());
		
		return value;
		
	}

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, Integer> m= new LinkedHashMap<>();
		m.put(1,10);		
		m.put(2,20);		
		m.put(3,30);		
		m.put(4,40);		
		m.put(5,50);		
		
		ArrayList<Integer> a= getValues(m);
		
		for(Integer b:a) {
			System.out.println(b);
		}
		
		
		
		
	}

}
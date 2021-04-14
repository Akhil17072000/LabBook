package com.LabBook6;



import java.util.HashMap;
import java.util.Scanner;

public class Ex2CountChar {
	
	static void countChars(char[] ch) {
		
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		  
        for (char c : ch)
        {
            if(charCountMap.containsKey(c))
            {
                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                    charCountMap.put(c, 1);
            }
        }
         
        System.out.println(charCountMap);
    }
		

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter the characters");
		String s=sc.nextLine();
		sc.close();
		
		countChars(s.toCharArray());
		

	}

}
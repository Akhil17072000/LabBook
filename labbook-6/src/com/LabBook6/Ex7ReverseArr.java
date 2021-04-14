package com.LabBook6;
import java.util.Scanner;

public class Ex7ReverseArr {
	static int[] reverse(int[] a) 
    { 
	 	int n= a.length; 
        int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        }
        return b;
    } 
  
    public static void main(String[] args) 
    { 
        Scanner sc= new Scanner(System.in);
        int[] a= new int[5];
        
        System.out.println("Enter array");
        for(int i=0;i<5;i++) {
        	a[i]=sc.nextInt();
        }
        sc.close();
        int[] b=reverse(a); 
        for(int i=0;i<5;i++) {
        	System.out.println(b[i]);
        }
    }

}



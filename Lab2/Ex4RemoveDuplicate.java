package com.capg.Lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4RemoveDuplicate {

	// simple java program to remove 
	// duplicates 

		// Function to remove duplicate elements 
		// This function returns new size of modified 
		// array. 
		static int[] modifyArray(int arr[], int n) 
		{ 
			// Return, if array is empty 
			// or contains a single element 
			if (n==0 || n==1) 
				return arr; 
		
			int[] temp = new int[n]; 
			
			
			// Start traversing elements 
			int j = 0; 
			for (int i=0; i<n-1; i++) { 
				// If current element is not equal 
				// to next element then store that 
				// current element 
				if (arr[i] != arr[i+1]) 
					temp[j++] = arr[i]; 
			}
			// Store the last element as whether 
			// it is unique or repeated, it hasn't 
			// stored previously 
			temp[j++] = arr[n-1]; 
			// Modify original array 
			int c=0;
			
			
			for(int i=1;i<temp.length;i++) {
				if(temp[i]!=0) {
					c++;
				}
				
			}
//			System.out.println(c);
			int temp1[] = new int[c+1];
			temp1[0] = temp[0];
			for (int i=1; i<temp1.length; i++) 
			{
				temp1[i] = temp[i];
			}
			
			for (int i=0; i<j; i++) 
				arr[i] = temp[i]; 
		
			return temp1; 
		} 
		
		public static void main (String[] args) 
		{ 
			Scanner sc = new Scanner(System.in);
			int m;
			m=sc.nextInt();
			int arr[]= new int[m];
			for(int i=0;i<m;i++) {
				arr[i]=sc.nextInt();
			}
			int n = arr.length; 
			Arrays.sort(arr);
			int[] temp = modifyArray(arr, n); 
			
			// Print updated array 
			for (int i=temp.length-1; i>=0; i--) 
			System.out.print(arr[i]+" "); 
		} 
	}
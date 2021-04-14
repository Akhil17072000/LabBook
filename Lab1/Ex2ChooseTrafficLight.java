package com.capg.Lab1;
import java.util.Scanner;

public class Ex2ChooseTrafficLight {
	enum traffic {
		Red,Yellow,Green;
	}

	public static void main(String[] args) {
		
		String choice= null;;
		Scanner sc= new Scanner(System.in);
	
		System.out.println("Welcome to Traffic Light Simulator..");
		System.out.println("Select one of the three options	");
		System.out.println("1. Red");
		System.out.println("2. Yellow");
		System.out.println("3. Green");
		
		choice=sc.nextLine();
		
		switch(traffic.valueOf(choice)) {
		
		case Red:
			System.out.println("Stop");
			break;
		case Yellow:
			System.out.println("Ready");
			break;
		case Green:
			System.out.println("Go");
		
		}

	}

}

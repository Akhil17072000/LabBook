package com.capg.Lab3;

import java.util.Scanner;

public class Ex5Text 
{   
    public static void main(String[] args) 
    {
        int charCount = 0;
        int wordCount = 0;
        
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
       
        String words[]=s.split(" ");
        wordCount=wordCount+words.length;
        
        for (String word : words)
        {
            charCount = charCount + word.length();
        }
       
        System.out.println("Number Of Chars In A File : "+charCount);
        
        System.out.println("Number Of Words In A File : "+wordCount);
    }   
}
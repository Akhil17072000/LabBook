package com.LabBook6;
import java.util.*;

public class Ex3ReturnSquare {
 
  public static HashMap<Integer,Integer> getSquares(int[] array) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 
    for (int n: array) {
      map.put( n, n*n);
    }
    return map;
  }
 
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    
    int[] array= new int[5];
    System.out.println("enter array values");
    for(int i=0;i<array.length;i++) {
    	array[i]=sc.nextInt();
    }
    
    sc.close();
    HashMap<Integer, Integer> map = getSquares(array);
 
    Iterator<Integer> it = map.keySet().iterator();
    while(it.hasNext()){
    Integer key = it.next();
      System.out.println(key + " : " + map.get(key));
    }
  }
}
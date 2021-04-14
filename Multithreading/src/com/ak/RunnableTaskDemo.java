package com.ak;


public class RunnableTaskDemo {



   public static void main(String[] args) {
       
       
       // option 1:
       RunnableTask task = new RunnableTask();
       Thread t1 = new Thread(task);
       t1.start();    
       
       //option 2:
       Runnable task2 = new Runnable() {
           @Override
           public void run() {                
               for(int i=11;i<=20;i++) {
                   System.out.print(i+" ");
               }    
           }            
       };
       
       Thread t2 = new Thread(task2);
       t2.start();
       
       //option 3: (lambda)        
       Runnable task3 = () -> {
           for(int i=21;i<=30;i++) {
               System.out.print(i+" ");
           }
       };        
       Thread t3 = new Thread(task3);
       t3.start();        
       
       
       
   }}
class RunnableTask implements Runnable {

	 

    @Override
    public void run() {    
        for(int i=1;i<=10;i++) {
            System.out.print(i+" ");
        }        
    }    
}
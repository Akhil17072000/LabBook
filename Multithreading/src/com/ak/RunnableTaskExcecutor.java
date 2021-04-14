package com.ak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 

public class RunnableTaskExcecutor {

 

    public static void main(String[] args) {
        
        Runnable task1 = () -> {
            for(int i=1;i<=30;i++) {
                System.out.println(Thread.currentThread().getName()+": "+i+" ");
            }
        };
        
        Runnable task2 = () -> {
            for(int i=51;i<=80;i++) {
                System.out.println(Thread.currentThread().getName()+": "+i+" ");
            }
        };
        
        Runnable task3 = () -> {
            for(int i=100;i<=120;i++) {
                System.out.println(Thread.currentThread().getName()+": "+i+" ");
            }
        };
        
        //ExecutorService service1 = Executors.newSingleThreadExecutor();
        
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        service1.execute(task1);
        service1.execute(task2);
        service1.execute(task3);
        

 

    }

 

}
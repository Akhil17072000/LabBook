package com.project.thread;



import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 

public class CallableDemo {

 

    public static void main(String[] args) throws Exception{
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
          FactorialTask task = new FactorialTask(5);
          
           Future<Integer> future = executorService.submit(task);
           System.out.println(future.get().intValue());          
           
           System.out.println("Main ends");
    }

 

}

 

class FactorialTask implements Callable<Integer> {
    int number;

 

    FactorialTask(int number) {
        this.number = number;
    }

 

    public Integer call() throws Exception {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }
        
        Thread.sleep(5000);

 

        return fact;
    }
}
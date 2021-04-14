package com.abc;

 

public class ProducerConsumerDemo {

 

    public static void main(String[] args) {
        
        ProducerConsumer pc = new ProducerConsumer();

 

        Thread producer = new Thread(pc, "Tree");
        Thread consumer1 = new Thread(pc, "Worm");

 

        producer.start();
        consumer1.start();

 

    }

 

}

 

class ProducerConsumer implements Runnable {

 

    int apples; // mainatins the count of the apples

 

    // Producer calls this method
    synchronized void produce() {
        while (true) {
            // produce apples only if there are <=100 apples
            if (apples > 100)
                try {
                    System.out.println("Waiting for apples to be eaten");
                    wait();
                } catch (InterruptedException e) {
                }
            try {
                int i = (int) (Math.random() * 100) + 1;
                Thread.sleep(i * 10); // time taken to produce apples
                apples = apples + i;
                System.out.println("Produced apples =" + apples);
            } catch (InterruptedException e) {
            }
            notify();
        }
    }

 

    // Consumers calls this method
    synchronized void consume() {
        while (true) {
            int i = (int) (Math.random() * 100) + 1;
            // consume only if there are enough apples
            if (apples > 0 && apples < i)
                try {
                    System.out.println(
                            Thread.currentThread().getName() + " waiting for " + (i - apples) + " more apples");
                    wait();
                } catch (InterruptedException e) {
                }

 

            try {
                System.out.println(Thread.currentThread().getName() + " busy eating  " + i + " apples");
                Thread.sleep(i); // time taken to consume apples
                apples = apples - i;
            } catch (InterruptedException e) {
            }
            notify();
        }
    }

 

    public void run() {
        if (Thread.currentThread().getName().equals("Tree"))
            produce();
        else
            consume();

 

    }
}
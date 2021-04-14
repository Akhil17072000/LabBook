package com.abc;

public class RunnableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main starts....");
		MyRunnableThread mt=new  MyRunnableThread();
		 Thread t1=new Thread(mt,"Th-1");
		 t1.start();
		 
		 Thread t2=new Thread(mt,"Th-2");
		 t2.start();
			System.out.println("Main end....");
		 
	}

}
class MyRunnableThread implements Runnable{
	@Override
	public void run() {
		for(int i=51;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
		}

	}
}
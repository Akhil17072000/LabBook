package com.abc;

public class ThreadDemoOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main starts....");
		MyThread mt=new MyThread();
		mt.setName("MYThread-1");
		mt.start();//indirectly calls run() method
		for(int i=51;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
		}
		System.out.println("Main end....");

	}

}
class MyThread extends Thread{
	public void run() {
		for(int i=51;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
		}
	}
}

package com.abc;

public class SleepMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main starts....");
		ThreadA t1=new ThreadA();
		t1.start();
		t1.setName("Th-A");
		System.out.println("Main end....");
		

	}

}
class ThreadA extends Thread
{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
			try {
			sleep(5000);
		}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
}
	}}

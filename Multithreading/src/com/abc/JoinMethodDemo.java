package com.abc;

public class JoinMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main starts....");
		ThreadB t1=new ThreadB();
		
		t1.setName("Th-B");
		t1.start();
		for(int i=1;i<=20;i++) {
		System.out.println(Thread.currentThread().getName()+": "+i);
		}System.out.println("Main end....");
		

	}
	}


class ThreadB extends Thread
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

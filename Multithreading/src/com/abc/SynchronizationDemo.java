package com.abc;

import java.util.*;

public class SynchronizationDemo {

	public static void main(String[] args) {
		
		MyResource resource = new MyResource();
		Thread8 threadone = new Thread8(resource);
		Thread8 threadtwo = new Thread8(resource); 
		Thread t1 = new Thread(threadone, "t1"); 
		Thread t2 = new Thread(threadtwo, "t2");
		t1.start();
		t2.start();

		}
}
		class Thread8 implements Runnable {
		private MyResource resource;
		Thread8(MyResource resource) { 
			this.resource=resource;
		}
		@Override
		public void run() { 
			resource.display();		
	}

}
		class MyResource {
				private List<String> list; 
				MyResource(){
				list = new ArrayList<>(); 
				list.add("java1");
				list.add("Java2"); 
				list.add("Java3");
				list.add("java4");
				list.add("java5");			
				list.add("java6");
				}
				synchronized void display() {
					System.out.println(Thread.currentThread().getName()+" Thread accessing ");
					for (String course:list) {
						System.out.println(course+" ");
				}
			}
}
package com.abc;

public class PrintNumbers {
	public static void main(String[] args) {
		
		OddEvenPrinter printer = new OddEvenPrinter();
		OddThread oddThread = new OddThread(20, printer);
		oddThread.setName("Odd-Thread");
		EvenThread evenThread = new EvenThread(20, printer);
		evenThread.setName("Even-Thread");
		oddThread.start();
		evenThread.start();
	}

}

class OddThread extends Thread
	{
		int limit;
		OddEvenPrinter printer;
		public OddThread(int limit, OddEvenPrinter printer)
			{	
				this.limit = limit;
				this.printer = printer;
			}
		@Override
		public void run() 
		{
			int oddNumber = 1;        //First odd number is 1
			while (oddNumber <= limit)
			{
				printer.printOdd(oddNumber);       //Calling printOdd() method of SharedPrinter class
				oddNumber = oddNumber + 2;         //Incrementing to next odd number
			}
		}
}

class EvenThread extends Thread
{
	int limit;
	OddEvenPrinter printer;
	public EvenThread(int limit, OddEvenPrinter printer)
	{
		this.limit = limit;
		this.printer = printer;
	}
	@Override
	public void run() 
	{
		int evenNumber = 2;           
		while (evenNumber <= limit)
		{
			printer.printEven(evenNumber);          
			evenNumber = evenNumber + 2;          
		}
	}
}
class OddEvenPrinter
{
	
	boolean isOddPrinted = false;
	
	synchronized void printOdd(int number)
	{
		while (isOddPrinted)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}
	System.out.println(Thread.currentThread().getName()+" : "+number);
	isOddPrinted = true;
	try
	{
		Thread.sleep(1000);
	} 
	catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	notify();
	}

	synchronized void printEven(int number)
	{
		while (!isOddPrinted)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+number);
		isOddPrinted = false;
		try
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		notify();
		}
	}

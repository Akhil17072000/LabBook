package com.capg.Lab4ex1;

public class BankActivity {
	
	int flag=0;
	public void deposit(Account account,double amount) {
		double currentBal=account.getBalance();
		double updatedBal=currentBal+amount;
		account.setBalance(updatedBal);
	}
	public void withdraw(Account account,double amount) {
		double currentBal=account.getBalance();
		if(currentBal>=amount) {
			flag=1;
		double updatedBal=currentBal-amount;
		account.setBalance(updatedBal);
		}
		else {
			flag=0;
			
			System.out.println("Insufficient Balance");
		}
		
	}
	public int transfer(Account fromAcc, Account toAcc, double amount) {
		double currentBalDebAcc=fromAcc.getBalance();
		double currentBalCreAcc=toAcc.getBalance();
		if(currentBalDebAcc>=amount) {
		flag=1;
		double updateBalDebAcc= currentBalDebAcc-amount;
		double updateBalCreAcc= currentBalCreAcc+amount;
		fromAcc.setBalance(updateBalDebAcc);
		toAcc.setBalance(updateBalCreAcc);
		}
		else
		{
			flag=0;
			System.out.println("Insufficient Balance");
		}
		return flag;
	}
	

}

package com.capg.Lab4ex1;

public class Saving extends BankActivity{
	
	final double minBal=5000;
	
	@Override
	public void withdraw(Account account,double amount) {
		if(minBal>=amount) {
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
	}

	@Override
	public int transfer(Account fromAcc, Account toAcc, double amount) {
		
		if(minBal>=amount) {
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
		}
		return flag;
		
	}
	
}

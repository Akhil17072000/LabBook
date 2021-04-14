package com.capg.Lab4ex1;

public class Current extends BankActivity{
	
	double overdraftLimit=50000;
	
	@Override
	public void withdraw(Account account,double amount) {
		if(overdraftLimit>=amount) {
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
		
		if(overdraftLimit>=amount) {
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
				System.out.println("OverDraft Limit Reached");
			}
		}
		return flag;
		
	}
	
}

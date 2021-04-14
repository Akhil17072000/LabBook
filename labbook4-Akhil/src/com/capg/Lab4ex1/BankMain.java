package com.capg.Lab4ex1;

public class BankMain {

	public static void main(String[] args) {
		
		BankActivity bank= new Saving();
		BankActivity bank2= new Current();
		Account account2=new Account();
		Account account3=new Account();
		Person p1= new Person();
		Person p2=new Person();
		
		double balance2=2000;
		account2.setAccNum(102);
		p1.setName("Smith");
		p1.setAge(25);
		account2.setAccountType("Saving Account");
		account2.setBalance(2000.0);
		account3.setAccNum(103);
		p2.setName("Kathy");
		p2.setAge(26);
		account3.setAccountType("Saving Account");
		account3.setBalance(3000.0);
		
		
		System.out.println("Before Transfer: Balance Available in debit account : "+
				account2.getBalance());
		System.out.println("Before Transfer: Balance Available in debit account : "+
				account3.getBalance());
		if(account2.getAccountType()=="Saving Account") {
		int a=bank.transfer(account2, account3, balance2);
		System.out.println();
		
		if(a==1) {
		System.out.println("After Transfer: Balance Available in debit account : "+
				account2.getBalance());
		System.out.println("After Transfer: Balance Available in credit account : "+
				account3.getBalance());
		}
		else {
			int b=bank2.transfer(account2, account3, balance2);
			System.out.println();
			
			if(b==1) {
			System.out.println("After Transfer: Balance Available in debit account : "+
					account2.getBalance());
			System.out.println("After Transfer: Balance Available in credit account : "+
					account3.getBalance());
			}
		}
		}

	}

}

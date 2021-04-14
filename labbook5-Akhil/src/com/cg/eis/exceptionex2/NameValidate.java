package com.cg.eis.exceptionex2;

public class NameValidate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter First Name");
//		String Fname=sc.next();
//		System.out.println("Enter Last Name");	
//		String Lname=sc.next();
//		sc.close();
		
		String Fname="Ram";
		String Lname=null;
		
		try {
		vote(Fname,Lname);
		}
		catch(FullNameException e) {
			System.out.println(e);
			
		}
	}
	static void vote(String Fname, String Lname) throws FullNameException {
		if(Fname==null && Lname==null) {
			FullNameException e= new FullNameException();
			throw e;
		}
		else {
			System.out.println("Name is Valid..");
		}
	}

}


	



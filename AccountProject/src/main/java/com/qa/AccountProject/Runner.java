package com.qa.AccountProject;

import java.util.HashMap;

public class Runner {
	
	public static void main(String args[]) {
		
		HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
		
		Account acc1=new Account();
		acc1.setFirstName("Tom");
		acc1.setLastName("Bamford");
		acc1.setAccountNumber(143);
		
		Service.addAccount(acc1,accountList);
		System.out.println(Service.retrieveAccount(acc1,accountList));
		
		
		
		
	}

}

package com.qa.AccountProject;

import java.util.HashMap;

public class Service {
	
	static HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
	
	public static void addAccount(Account acc) {
		
		accountList.put(acc.getAccountNumber(),acc);
		
	}
	
	public static Account retrieveAccount(Account acc) {
		return accountList.get(acc.getAccountNumber());
	}
	
	public static int firstNameNumberMethod(String string) {
	    
		int count=0;
		Account acc = new Account();
		
		for (Account value : accountList.values()) {
			
			acc=Service.retrieveAccount(value);
			
			if(acc.getFirstName().equals(string)) {
				count++;
			}
			
		}
		
		return count;
	}
	

}

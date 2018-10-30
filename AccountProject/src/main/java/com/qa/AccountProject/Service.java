package com.qa.AccountProject;

import java.util.HashMap;

public class Service {
	
	public static void addAccount(Account acc, HashMap<Integer,Account> list) {
		
		list.put(acc.getAccountNumber(),acc);
		
	}
	
	public static Account retrieveAccount(Account acc, HashMap<Integer,Account> list) {
		return list.get(acc.getAccountNumber());
	}

}

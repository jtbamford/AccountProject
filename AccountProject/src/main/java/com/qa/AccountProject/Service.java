package com.qa.AccountProject;

import java.util.HashMap;

import javax.inject.Inject;

import com.qa.AccountProject.DatabaseImpl;

public class Service {
		
		static HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
		
		public static void addAccount(Account acc) {
			
			accountList.put(acc.getAccountNumber(),acc);
			
		}
		
		public static Account retrieveAccount(Account acc) {
			return accountList.get(acc.getAccountNumber());
		}
		
		public static int firstNameNumberMethod(String string) {
		    
			return (int) accountList.values().stream().filter(i->i.getFirstName().equals(string)).count();
		}
	}
	

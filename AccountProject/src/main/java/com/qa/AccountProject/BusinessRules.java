package com.qa.AccountProject;

import javax.inject.Inject;

public class BusinessRules implements Accountable {
	
	@Inject
	private Accountable repo;
	
	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	@Override
	public String addAccount(Account acc) {
		if(blockedAccount(acc.getAccountNumber())) {
			return "{\"message\": \"This account is blocked\"}";
		} else {
		return repo.addAccount(acc);
		}
	}
	
	@Override
	public String deleteAccount(int accountNumber) {
		return repo.deleteAccount(accountNumber);
	}
	
	@Override
	public Account retrieveAccount(int accountNumber) {
		return repo.retrieveAccount(accountNumber);
	}
	
	@Override
	public String updateAccount(Account account, int accountNumber) {
		return repo.updateAccount(account, accountNumber);
	}
	
	public Boolean blockedAccount(int accountNumber) {
		if(accountNumber==9999) {
			return true;
		} else {
			return false;
		}
		
	}

}

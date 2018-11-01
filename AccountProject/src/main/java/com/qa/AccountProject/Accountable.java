package com.qa.AccountProject;

public interface Accountable {

	public String getAllAccounts();
	
	public String addAccount(Account acc);
	
	public String deleteAccount(int accountNumber);
	
	public String updateAccount(Account account, int accountNumber);
	
	public String retrieveAccount(int accountNumber);

}

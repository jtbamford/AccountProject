package com.qa.AccountProject;

import java.util.HashMap;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

//import com.qa.business.service.AccountService;
import com.qa.AccountProject.Account;
import com.qa.AccountProject.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountRepositoryAlt {

	static HashMap<Integer, Account> accountListAlt = new HashMap<Integer, Account>();
	
	@Inject
	private JSONUtil util;
	
	public List<Account> getAllAccounts() {
		    return (List<Account>) accountListAlt.values();
	}
	
	public String addAccount(Account acc) {
		accountListAlt.put(acc.getAccountNumber(),acc);
		return "Account Added";
	}
	
	
	public String deleteAccount(int accountNumber) {
		Account accountInDB = retrieveAccount(accountNumber);
		if (accountInDB != null) {
			accountListAlt.remove(accountInDB.getAccountNumber());
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private Account retrieveAccount(int accountNumber) {
		return accountListAlt.get(accountNumber);
	}
	
	public String updateAccount(Account account, int accountNumber) {
		Account accountold=retrieveAccount(accountNumber);
		accountold.setFirstName(account.getFirstName());
		accountold.setLastName(account.getLastName());
		accountold.setAccountNumber(account.getAccountNumber());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}
	

}

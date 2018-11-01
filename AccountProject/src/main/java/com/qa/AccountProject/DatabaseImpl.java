package com.qa.AccountProject;

import java.util.HashMap;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

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

@Transactional(SUPPORTS)
public class DatabaseImpl {
	
	//static HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		HashMap<Integer, Account> accountList = (HashMap<Integer, Account>) query.getResultList();
		return util.getJSONForObject(accountList);
	}
	
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account anAccount = JSONUtil.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	//public static void addAccount(Account acc) {
		
	//	accountList.put(acc.getAccountNumber(),acc);
		
	//}
	
	@Transactional(REQUIRED)
	public String deleteAccount(int accountNumber) {
		Account accountInDB = retrieveAccount(accountNumber);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private Account retrieveAccount(int accountNumber) {
		return manager.find(Account.class, accountNumber);
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Account account, int accountNumber) {
		Account accountold=retrieveAccount(accountNumber);
		accountold.setFirstName(account.getFirstName());
		accountold.setLastName(account.getLastName());
		accountold.setAccountNumber(account.getAccountNumber());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}
	

	
	//public static Account retrieveAccount(Account acc) {
	//	return accountList.get(acc.getAccountNumber());
	//}
	

}

package com.qa.AccountProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.qa.AccountProject.Account;

public class BlockedAccountTest {
	
	@Test
	public void blockedAccountTestMethod() {
		Account acc = new Account();
		BusinessRules br1 = new BusinessRules();
		acc.setAccountNumber(9999);
		acc.setFirstName("hjg");
		acc.setLastName("vfbn");
		assertEquals(true,br1.blockedAccount(acc.getAccountNumber()));
	}

}

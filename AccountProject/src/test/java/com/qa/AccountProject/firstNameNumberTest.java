package com.qa.AccountProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class firstNameNumberTest {
	
	@Test
	public void firstNameNumberMethodTest() {
		
		Account acc1 = new Account();
		acc1.setFirstName("Tom");
		acc1.setLastName("Bamford");
		acc1.setAccountNumber(143);

		Account acc2 = new Account();
		acc2.setFirstName("Mot");
		acc2.setLastName("Bad");
		acc2.setAccountNumber(463);

		Service.addAccount(acc1);
		Service.addAccount(acc2);
		
		assertEquals(1,Service.firstNameNumberMethod("Tom"));
	}


	
}

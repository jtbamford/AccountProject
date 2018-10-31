package com.qa.AccountProject;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class firstNameNumberTest {
	
	@Test
	public void firstNameNumberMethodTest() {
		
		Assert.assertEquals(1,firstNameNumberMethod("Tom"));
	}

}

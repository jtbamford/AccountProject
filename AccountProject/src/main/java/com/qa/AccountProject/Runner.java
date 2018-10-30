package com.qa.AccountProject;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Runner {
	
	public static void main(String args[]) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		HashMap<Integer, Account> accountList = new HashMap<Integer, Account>();
		
		Account acc1=new Account();
		acc1.setFirstName("Tom");
		acc1.setLastName("Bamford");
		acc1.setAccountNumber(143);
		
		Account acc2=new Account();
		acc2.setFirstName("Mot");
		acc2.setLastName("Bad");
		acc2.setAccountNumber(463);
		
		Service.addAccount(acc1,accountList);
		Service.addAccount(acc2,accountList);
		//System.out.println(Service.retrieveAccount(acc1,accountList));
		
		
		//String ans=mapper.writeValueAsString(acc1);
		
		try {

			// Convert object to JSON string
			for(Account value : accountList.values()) {
			String jsonInString = mapper.writeValueAsString(Service.retrieveAccount(value,accountList));
			System.out.println(jsonInString);
			}
			


		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

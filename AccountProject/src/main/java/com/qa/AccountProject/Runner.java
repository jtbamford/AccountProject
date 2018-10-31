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

	
		// System.out.println(Service.retrieveAccount(acc1,accountList));

		// String ans=mapper.writeValueAsString(acc1);
		

		try {

			// Convert object to JSON string
			for (Account value : accountList.values()) {
				String jsonInString = mapper.writeValueAsString(Service.retrieveAccount(value));
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

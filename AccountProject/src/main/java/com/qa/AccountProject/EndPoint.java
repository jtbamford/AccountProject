package com.qa.AccountProject;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.AccountProject.Accountable;

@Path("/account")
public class EndPoint {
	
	@Inject
	private Accountable accountable;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return accountable.getAllAccounts();
	}

	@Path("/createAccount/{account}")
	@POST
	@Produces({ "application/json" })
	public String addAccount(@PathParam("account") String accountJSON) {
		Account acc=JSONUtil.getObjectForJSON(accountJSON,Account.class);
		return accountable.addAccount(acc);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") int id) {
		return accountable.deleteAccount(id);
	}

	@Path("/updateAccount/{id}/{account}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("account") String accountJSON,@PathParam("id") int id) {
		Account acc=JSONUtil.getObjectForJSON(accountJSON,Account.class);
		return accountable.updateAccount(acc, id);
	}


}


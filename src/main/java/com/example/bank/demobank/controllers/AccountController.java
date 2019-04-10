package com.example.bank.demobank.controllers;

import com.example.bank.demobank.business.AccountManager;
import com.example.bank.demobank.domain.entities.Account;
import com.example.bank.demobank.domain.entities.Customer;
import com.example.bank.demobank.exceptions.AccountNotPresentException;
import com.example.bank.demobank.exceptions.NoCustomerFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

	@Autowired
	private AccountManager accountManager;

	@GetMapping (value = "/account/all")
	public List<Account> getAllAccounts(){
		return accountManager.findAll();
	}

	@GetMapping (value = "/account/{accountId}")
	public Account getAccountById (@PathVariable Long accountId) throws NoCustomerFoundException {

		return accountManager.findById(accountId);
	}

	@PostMapping (value = "/account")
	public Account saveAccount (@RequestBody Account account){

		if (account.getAccountId()== null || account.getAccountId() < 0)
			return accountManager.createAccount(account);

		return null;
	}

	@DeleteMapping (value = "/account/{accountId}")
	public void deleteCustomer (@PathVariable Long accountId ) throws AccountNotPresentException {
		accountManager.deleteAccount(accountId);
	}

}

package com.example.bank.demobank.business;

import com.example.bank.demobank.domain.entities.Account;
import com.example.bank.demobank.domain.entities.Customer;
import com.example.bank.demobank.exceptions.AccountNotPresentException;
import com.example.bank.demobank.exceptions.BalanceBelowZeroException;

import java.util.List;

public interface AccountManager {



	Account createAccount(Account account);
	Account deactivateAccount(Long accountId) throws AccountNotPresentException;
	Account activateAccount(Long accountId) throws AccountNotPresentException;
	Account depositAmmount (Long accoutId, Double ammount) throws AccountNotPresentException;
	Account withdrawAmmount (Long accoutId, Double ammount) throws AccountNotPresentException, BalanceBelowZeroException;

	List<Account> findAll();

	Account findById(Long accountId);

	void deleteAccount(Long accountId) throws AccountNotPresentException;
}

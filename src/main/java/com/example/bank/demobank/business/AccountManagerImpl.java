package com.example.bank.demobank.business;

import com.example.bank.demobank.domain.entities.Account;
import com.example.bank.demobank.domain.repositories.AccountRepository;
import com.example.bank.demobank.exceptions.AccountNotPresentException;
import com.example.bank.demobank.exceptions.BalanceBelowZeroException;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AccountManagerImpl implements AccountManager {
	@Autowired
	AccountRepository repository;

	@Override
	public Account createAccount(Account account) {
		return repository.save(account);
	}

	@Override
	public Account deactivateAccount(Long accountId) throws AccountNotPresentException {
		Account account = findAccount(accountId);

		account.setActive(false);
		return repository.save(account);
	}

	@Override
	public Account activateAccount(Long accountId) throws AccountNotPresentException {
		Account account = findAccount(accountId);

		account.setActive(true);
		return repository.save(account);
	}

	@Override
	public Account depositAmmount(Long accountId, Double ammount) throws AccountNotPresentException {
		Account account = findAccount(accountId);
		account.setBalance(account.getBalance()+ammount);
		repository.save(account);
		return account;
	}

	@Override
	public Account withdrawAmmount(Long accountId, Double ammount) throws AccountNotPresentException, BalanceBelowZeroException {
		Account account = findAccount(accountId);
		if (account.getBalance() - ammount < 0)
			throw new BalanceBelowZeroException("No se puede sacar tanto dinero");


		account.setBalance(account.getBalance()-ammount);
		repository.save(account);
		return account;
	}

	@Override
	public List<Account> findAll() {
		return repository.findAll();
	}

	@Override
	public Account findById(Long accountId) {
		try {
			return findAccount(accountId);
		}catch (AccountNotPresentException nre){
			return null;
		}
	}

	@Override
	public void deleteAccount(Long accountId) throws AccountNotPresentException {
		Account account = findAccount(accountId);
		Preconditions.checkArgument(!account.getActive(), "La cuenta está activa, desactivela");
		Preconditions.checkArgument(account.getBalance().isNaN() || new Double(0).equals(account.getBalance()), "La cuenta tiene dinero.");

		repository.delete(account);

	}

	private Account findAccount(Long accountId) throws AccountNotPresentException{
		Account account = repository.findById(accountId).orElse(null);
		if (account == null)
			throw new AccountNotPresentException("La cuenta con id "+accountId+" no existe" );

		return account;
	}
}

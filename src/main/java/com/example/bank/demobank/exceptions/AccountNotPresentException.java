package com.example.bank.demobank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such account")
public class AccountNotPresentException extends Exception {
	public AccountNotPresentException(String s) {
		super(s);
	}
}

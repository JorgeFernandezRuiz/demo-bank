package com.example.bank.demobank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")
public class NoCustomerFoundException extends Exception {
	public NoCustomerFoundException(String s) {
		super(s);
	}
}

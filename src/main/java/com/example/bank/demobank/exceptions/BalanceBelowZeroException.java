package com.example.bank.demobank.exceptions;

public class BalanceBelowZeroException extends Exception {
	public BalanceBelowZeroException(String s) {
		super(s);
	}
}

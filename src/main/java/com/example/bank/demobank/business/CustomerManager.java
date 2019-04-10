package com.example.bank.demobank.business;

import com.example.bank.demobank.domain.entities.Customer;
import com.example.bank.demobank.exceptions.NoCustomerFoundException;

import java.util.List;

public interface CustomerManager {

	Customer createCustomer(Customer customer);
	Customer updateCustomer (Customer customer);
	void deleteCustomer(Long customerId);
	Customer findById (Long customerId) throws NoCustomerFoundException;
	List<Customer> findAll ();
}

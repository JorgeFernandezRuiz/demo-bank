package com.example.bank.demobank.business;

import com.example.bank.demobank.domain.entities.Customer;
import com.example.bank.demobank.domain.repositories.CustomerRepository;
import com.example.bank.demobank.exceptions.NoCustomerFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagerImpl implements CustomerManager {
	@Autowired
	CustomerRepository repository;

	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		repository.deleteById(customerId);
	}

	@Override
	public Customer findById(Long customerId) throws NoCustomerFoundException {
		return repository.findById(customerId).orElseThrow(() -> new NoCustomerFoundException("No existe customer con ese ID"));
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

}

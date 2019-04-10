package com.example.bank.demobank.controllers;

import com.example.bank.demobank.business.CustomerManager;
import com.example.bank.demobank.domain.entities.Customer;
import com.example.bank.demobank.exceptions.NoCustomerFoundException;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class CustomerController {

	@Autowired
	private CustomerManager customerManager;

	@GetMapping (value = "/customer/all")
	public List<Customer> getCustomers (){
		return customerManager.findAll();
	}

	@GetMapping (value = "/customer/{customerId}")
	public Customer getCustomerById (@PathVariable Long customerId) throws NoCustomerFoundException {

		return customerManager.findById(customerId);
	}

	@PostMapping (value = "/customer")
	public Customer saveCustomer (@RequestBody Customer customer){

		Preconditions.checkArgument(customer.getCustomerId()==null || customer.getCustomerId()<0, "El id del Customer debe estar vacio");

		return customerManager.createCustomer(customer);


	}
	@PutMapping (value = "/customer")
	public Customer updateCustomer (@RequestBody Customer customer){
		Preconditions.checkArgument(customer.getCustomerId()!=null && customer.getCustomerId()>0);

		return customerManager.updateCustomer(customer);
	}



		@DeleteMapping (value = "/customer/{customerId}")
	public void deleteCustomer (@PathVariable Long customerId ){
		customerManager.deleteCustomer(customerId);
	}

}

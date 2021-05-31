package com.capgemini.AccountModule.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.AccountModule.entity.Customer;
import com.capgemini.AccountModule.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> list() {
	    return customerService.listAllCustomer();
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> get(@PathVariable Long id) {
	    try {
	        Customer customer = customerService.findCustomer(id);
	        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/customers")
	public Customer add(@RequestBody Customer customer) {
	    Customer cust = customerService.addCustomer(customer);
		return cust;
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Long id) {
	    try {
	        Customer existCustomer = customerService.findCustomer(id);
	        customerService.updateCustomer(customer,id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable Long id) {
	    customerService.deleteCustomer(id);
	}
}

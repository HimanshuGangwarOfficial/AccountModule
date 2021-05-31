package com.capgemini.AccountModule.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.AccountModule.entity.Customer;
import com.capgemini.AccountModule.repository.CustomerRepository;


@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }
     
     
    public Customer findCustomer(Long id) {
        return customerRepository.findById(id).get();
    }
     
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
    public Customer updateCustomer(Customer customer,Long id) {
    	Optional<Customer> findById = customerRepository.findById(id);
    	findById.get().setCustomerName(customer.getCustomerName());
    	findById.get().setCustomerZip(customer.getCustomerZip());
    	Customer cust = customerRepository.save(findById.get());
    	return cust;
    			
    }
}

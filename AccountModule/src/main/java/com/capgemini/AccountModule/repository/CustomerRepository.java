package com.capgemini.AccountModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.AccountModule.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

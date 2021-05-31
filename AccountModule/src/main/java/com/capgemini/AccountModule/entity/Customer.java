package com.capgemini.AccountModule.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private Long customerZip;	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Long customerId, String customerName, Long customerZip) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerZip = customerZip;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getCustomerZip() {
		return customerZip;
	}
	public void setCustomerZip(Long customerZip) {
		this.customerZip = customerZip;
	}
	
	
}

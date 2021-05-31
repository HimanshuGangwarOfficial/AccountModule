package com.capgemini.AccountModule.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accId;
	@OneToOne
	private User userId;
	
	@OneToMany
	private List<Customer> customerId;
	
	public Account() {
		super();
	}

	public Account(Long accId, User userId, List<Customer> customerId) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.customerId = customerId;
	}

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<Customer> getCustomerId() {
		return customerId;
	}

	public void setCustomerId(List<Customer> customerId) {
		this.customerId = customerId;
	}


	
}

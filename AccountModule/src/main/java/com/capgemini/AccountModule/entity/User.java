package com.capgemini.AccountModule.entity;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String password;
	@ElementCollection
	private List<String> userRoles;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long userId, String userName, String password, List<String> userRoles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRoles = userRoles;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<String> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	public String getUserRoleForLogin() {
		if(userRoles.contains("Admin"))
			return "Admin";
		else
			return "User";
	}
	

}

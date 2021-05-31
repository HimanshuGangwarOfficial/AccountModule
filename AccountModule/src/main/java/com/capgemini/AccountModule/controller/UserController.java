package com.capgemini.AccountModule.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.AccountModule.entity.User;
import com.capgemini.AccountModule.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/users")
	public User addAccount(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User u = userService.addUser(user);
		//u.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(u.getPassword());
		return u;	
	}
	
	@GetMapping("/users")
	public List<User> list() {
	    return userService.listAllCustomer();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
	    try {
	    	User user = userService.findCustomer(id);
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
	    try {
	    	User existUser = userService.findCustomer(id);
	    	userService.updateCustomer(user,id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteCustomer(id);
	}
}

package com.capgemini.AccountModule.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.AccountModule.entity.User;
import com.capgemini.AccountModule.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);		
	}
	
	public List<User> listAllCustomer() {
        return userRepository.findAll();
    }
     
     
    public User findCustomer(Long id) {
        return userRepository.findById(id).get();
    }
     
    public void deleteCustomer(Long id) {
    	userRepository.deleteById(id);
    }
    
    public User updateCustomer(User user,Long id) {
    	Optional<User> findById = userRepository.findById(id);
    	findById.get().setFirstName(user.getFirstName());
    	findById.get().setLastName(user.getLastName());
    	findById.get().setUserName(user.getUserName());
    	findById.get().setPassword(user.getPassword());
    	findById.get().setUserRoles(user.getUserRoles());
    	return userRepository.save(findById.get());
    			
    }
}

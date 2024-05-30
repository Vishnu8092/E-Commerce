package com.learn.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.model.Admin;
import com.learn.model.UserDetails;
import com.learn.repository.AdminRepository;
import com.learn.repository.UserRepository;

@Service
public class CustomerImpl {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	public String UserAndAdminLogin(String email , String password) {
		List<UserDetails> userList = getUser();
		List<Admin> adminList = getAdmin();
		for(UserDetails userDetails: userList) {
			if(userDetails.getEmail().equals(email) && userDetails .getPassword().equals(password) ) {
				return "customer";
			}
		}
		for(Admin admin:adminList) {
			if(admin.getAdminEmail().equals(email) && admin.getAdminPassword().equals(password) ) {
				return "admin";
			}
		}
		
		
		return "InvalidUser";
	}
	
	public List<UserDetails> getUser (){
		
		return userRepository.findAll();
	}
	
public List<Admin> getAdmin (){
		
		return adminRepository.findAll();
	}
	
	
}

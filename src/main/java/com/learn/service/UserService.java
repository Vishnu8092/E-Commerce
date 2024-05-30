package com.learn.service;

import com.learn.model.UserDetails;
public interface UserService {

	
public UserDetails createUser(UserDetails user);
	
	public boolean checkEmail(String email);
	
	/* public UserDetails userDetails(String email,String password); */
}

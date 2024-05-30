package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.UserDetails;
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	public boolean existsByEmail(String email) ;
	
	
	
}

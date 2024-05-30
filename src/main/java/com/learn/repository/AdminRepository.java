package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	
	
}

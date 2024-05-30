package com.learn.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learn.model.Category;
public interface CategoryImpl extends JpaRepository<Category, Integer> {
	@Query("select c from Category c where c.id = :id " )
	
	 List<Category>findAllByCat_id(@Param("id") int id);
}

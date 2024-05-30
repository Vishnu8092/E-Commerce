package com.learn.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learn.model.Product;
public interface ProductImpl extends JpaRepository<Product, Long> {
	
	  @Query("select p from Product p where p.category.id = :id " ) List<Product>
	  findAllByCat_id(@Param("id") int id);
	 

	
}

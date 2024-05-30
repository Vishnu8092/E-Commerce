package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.impl.CategoryImpl;
import com.learn.impl.ProductImpl;
import com.learn.model.Product;

@Service
public class ProductService {

	@Autowired
	CategoryImpl categoryImpl;

	@Autowired
	ProductImpl productImpl;

	public List<Product> getAllProduct() {
		return productImpl.findAll();
	}

	public void addProduct(Product product) {
		productImpl.save(product);
	}

	public void removeProductById(Long id) {
		productImpl.deleteById(id);
		/* productImpl.removeById(id); */
	}

	public Optional<Product> getProductById(long id) {
		return productImpl.findById(id);
	}

	
	/*
	 * public List<Category> getAllProductByCategoryId(int id) { return
	 * categoryImpl.findAllByCat_id(id); }
	 */
	 

	
	  public List<Product>getAllProductByCategoryId(int id){ 
		  return productImpl.findAllByCat_id(id);
	 }
	 

}

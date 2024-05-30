package com.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.impl.CategoryImpl;
import com.learn.model.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryImpl categoryImpl;

	public List<Category> getAllCategory() {
		return categoryImpl.findAll();
	}

	public void addCategory(Category category) {
		categoryImpl.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryImpl.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id){
		return categoryImpl.findById(id);
	}
	
	
	
	
	
	
}

package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.global.GlobalData;
import com.learn.model.UserDetails;
import com.learn.service.UserService;
import com.learn.service.CategoryService;
import com.learn.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("cartCount",GlobalData.cart.size());
		
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDetails user,Model model) {
		
		boolean f = userService.checkEmail(user.getEmail());
		if(f) {
			model.addAttribute("msg","Email id has been already exists");
			
		}
		else {
			UserDetails userDetails=userService.createUser(user);
			if(userDetails!=null) {
				model.addAttribute("msg","Register Successfully");
			}else {
				model.addAttribute("msg","Somthing went wrong please try again");
			}
		}
		
		return"register";
	}
	
	
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProduct());
		model.addAttribute("cartCount",GlobalData.cart.size());
		
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model , @PathVariable int id) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		model.addAttribute("cartCount",GlobalData.cart.size());
		
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model , @PathVariable int id) {
		model.addAttribute("product",productService.getProductById(id).get());
		model.addAttribute("cartCount",GlobalData.cart.size());

		return "viewProduct";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

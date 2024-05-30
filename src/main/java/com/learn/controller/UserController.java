package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.global.GlobalData;
import com.learn.impl.CustomerImpl;

@Controller
public class UserController {
	@Autowired
	CustomerImpl customerImpl;
	
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		
		return "login";
	}
	
	@PostMapping("/login")
	private String CustomerAuthentication(@RequestParam ("email")String email,@RequestParam("password") String password ,Model  model) {
		
		String data = customerImpl.UserAndAdminLogin(email, password);
		if(data.equals("customer")) {
			return "index";
		}
		
		if(data.equals("admin")) {
			return "adminHome";
		}
		else {
			model.addAttribute("error","Invalid username and password");
			return"login";
		}
		
	}
	
	
}

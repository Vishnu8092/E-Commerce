package com.learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullname;
	
	private String email;
	
	private String address;
	
	private String mobile;
	
	private String password;

	
	
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetails(int id, String fullname, String email, String address, String mobile, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
	}

	public UserDetails(String fullname, String email, String address, String mobile, String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
	}

	public UserDetails() {
		super();
	}
	
	
	
	
}

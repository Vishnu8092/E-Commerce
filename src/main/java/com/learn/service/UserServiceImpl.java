package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.model.UserDetails;
import com.learn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	/*
	 * @Autowired private HibernateTemplate hibernateTemplate;
	 */
	
	
	@Override
	public UserDetails createUser(UserDetails user) {
		
		return userRepository.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}

	/*
	 * @Override public UserDetails userDetails(String email, String password) {
	 * 
	 * String sql = "from UserDetails where email:em and password:pwd";
	 * User us=(User)hibernateTemplate.execute(s->{ Query<R> q = s.createQuery(sql);
	 * q.setString("em",email); q.setString("pwd"password); return q.uniqueResult();
	 * });
	 * 
	 * 
	 * return us; }
	 */
	
	
	
}

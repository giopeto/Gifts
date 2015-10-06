package com.gifts.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gifts.users.domain.User;
import com.gifts.users.repository.UsersRepository;
@Service
public class UsersService {

	@Autowired
	private static UsersRepository repository;
	
	public static Map<String, Object> createAccount(User user) {
		
		repository.save(user);
		System.out.println(repository.count());
		
		Map<String, Object> returnUser = new HashMap<>();
		returnUser.put("user", repository.findByUserNameAndPassword(user.getUserName(), user.getPassword()));
		
		return returnUser;
		
	}
	
	
	
	public User findByUserNameAndPassword(String username, String password) {
		
		return repository.findByUserNameAndPassword(username, password);
		
	}
	
	

}

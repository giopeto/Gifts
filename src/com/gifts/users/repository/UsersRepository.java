package com.gifts.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gifts.users.domain.User;
	
@Repository
public interface UsersRepository extends MongoRepository<User, String> {

	public User findByUserNameAndPassword (String userName, String password);
	
	//public List<Users> findByLastName(String lastName);
	
	
	
	
	
	
	
	
	
	
}

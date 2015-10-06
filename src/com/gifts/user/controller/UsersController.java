package com.gifts.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gifts.user.service.UsersService;
import com.gifts.users.domain.User;
import com.gifts.users.repository.UsersRepository;

@RestController
public class UsersController {

	/*@Autowired
	private UsersRepository repository;*/
	
	
	@RequestMapping(
			value="/createAccount",
			method = RequestMethod.POST,
			headers="Accept=application/json", 
			produces="application/json"
	)
	
	public Map<String, Object>  createAccount(@RequestBody Map<String, String> userParams) { 
		
		/*String id, String firstName, String lastName, String userName,
		String password, String email*/
		
		
		
		User user = new User((String)userParams.get("_id"), (String)userParams.get("firstName"), 
				(String)userParams.get("lastName"), (String)userParams.get("userName"), (String)userParams.get("email"), (String)userParams.get("password"));
		//return UsersService.createAccount(user, repository);
		return UsersService.createAccount(user);
		
		
	}
	
}


/*@RequestMapping(
		value="/createAccount",
		method = RequestMethod.POST
		//, headers="Accept=application/json", 
		//produces="application/json"
)
public Map<String, Object>  createAccount(@RequestBody Map<String, String> userParams) { 
	System.out.println(userParams);
	User user = new User((String)responseUser.get("_id"), (String)responseUser.get("name"), 
			(String)responseUser.get("email"), (String)responseUser.get("password"));
	return LoginService.createAccount(user);
	
}*/


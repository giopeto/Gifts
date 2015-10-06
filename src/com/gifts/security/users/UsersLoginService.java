package com.gifts.security.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gifts.user.service.UsersService;
import com.gifts.users.domain.User;

@Service
@Component
public class UsersLoginService implements UserDetailsService {
	
	@Autowired
    UsersService usersService;
	
	@Autowired
    private SecUserDetails userdetails;
	
	public SecUserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
		
		
		User user = (User) usersService.findByUserNameAndPassword(username, password);
		
		userdetails = new SecUserDetails(user);
		if (userdetails == null) {
			throw new UsernameNotFoundException(username);
		} else {
			return userdetails;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.gifts.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.gifts.security.users.UsersLoginService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Qualifier("userDetailsService")
	UserDetailsService userLoginService;
	
	/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }*/
    
    
	
	@Override 
	protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		registry.userDetailsService(userLoginService);
	}
	
	
	/*@Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService); 
    }*/
	
	/*protected void configure(HttpSecurity http) throws Exception {
	      http
	        .httpBasic()
	      .and()
	        .authorizeRequests()
	          .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
	          .anyRequest().authenticated();
	    }*/
	
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()                                    
                .permitAll();
    }
    
    
    
    
}
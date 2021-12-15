package com.canada.guusto.microservice.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.canada.guusto.microservice.auth.client.UserFeignClient;
import com.canada.guusto.microservice.auth.model.Users;

@Service
public class UsersService implements UserDetailsService{

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userFeignClient.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new User(user.getUsername(), user.getPassword(), new ArrayList<GrantedAuthority>());
	}

}

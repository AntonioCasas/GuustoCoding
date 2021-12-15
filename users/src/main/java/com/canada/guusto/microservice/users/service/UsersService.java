package com.canada.guusto.microservice.users.service;

import com.canada.guusto.microservice.users.model.Users;

public interface UsersService {
	
	public Users getUserByName(String username);

}

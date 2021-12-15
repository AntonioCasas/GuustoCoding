package com.canada.guusto.microservice.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.canada.guusto.microservice.users.model.Users;
import com.canada.guusto.microservice.users.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@GetMapping("/user/{username}")
	public Users getUserByUsername(@PathVariable String username) {
		return usersService.getUserByName(username);
	}
	
}

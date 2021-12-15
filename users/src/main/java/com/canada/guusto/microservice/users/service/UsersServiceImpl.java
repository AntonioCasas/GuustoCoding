package com.canada.guusto.microservice.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.guusto.microservice.users.dao.UsersDao;
import com.canada.guusto.microservice.users.model.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public Users getUserByName(String username) {
		return usersDao.getUserByName(username);
	} 

}

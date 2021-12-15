package com.canada.guusto.microservice.users.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.canada.guusto.microservice.users.model.Users;

public interface UsersDao extends CrudRepository<Users, Long> {
	
	@Query("select u from Users u where username=?1")
	public Users getUserByName(String username);

}

package com.canada.guusto.microservice.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.canada.guusto.microservice.auth.model.Users;

@FeignClient(name="service-users")
public interface UserFeignClient {
	
	@GetMapping("/user/{username}")
	public Users getUserByUsername(@PathVariable String username);
	

}

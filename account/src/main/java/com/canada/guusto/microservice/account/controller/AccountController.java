package com.canada.guusto.microservice.account.controller;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canada.guusto.microservice.account.pojo.AccountPojo;
import com.canada.guusto.microservice.account.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account/{userId}")
	public AccountPojo getAccountByUserId(@PathVariable Long userId) {
		return accountService.getAccountByUserId(userId);
	}
	
	@PutMapping("/account")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public void updateAccount(@RequestBody AccountPojo account) {
		accountService.updateAccount(account.getAmount(), account.getId());
	}	
	

}

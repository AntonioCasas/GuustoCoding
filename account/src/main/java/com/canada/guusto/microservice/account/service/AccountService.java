package com.canada.guusto.microservice.account.service;

import com.canada.guusto.microservice.account.pojo.AccountPojo;

public interface AccountService {
	
	public AccountPojo getAccountByUserId(Long userId);
	
	public void updateAccount(Double amount, Long id);

}

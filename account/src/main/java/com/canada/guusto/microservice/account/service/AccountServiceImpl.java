package com.canada.guusto.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.guusto.microservice.account.model.Account;
import com.canada.guusto.microservice.account.model.Users;
import com.canada.guusto.microservice.account.model.dao.AccountDao;
import com.canada.guusto.microservice.account.pojo.AccountPojo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountPojo getAccountByUserId(Long userId) {
		return toPojo(accountDao.getAccountByUserId(userId));
	}
	
	@Override
	public void updateAccount(Double amount, Long id) {
		accountDao.updateAccount(amount, id);		
	}
	
	private AccountPojo toPojo(Account account) {
		AccountPojo pojo = new AccountPojo();
		pojo.setId(account.getId());
		pojo.setUserId(account.getUser().getId());
		pojo.setAmount(account.getAmount());
		return pojo;
	}
	
	private Account toModel(AccountPojo pojo) {
		Account account = new Account();
		account.setId(pojo.getId());
		account.setAmount(pojo.getAmount());
		Users user = new Users();
		user.setId(pojo.getUserId());
		account.setUser(user);
		return account;
	}

}

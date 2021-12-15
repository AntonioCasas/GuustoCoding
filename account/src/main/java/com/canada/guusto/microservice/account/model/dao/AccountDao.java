package com.canada.guusto.microservice.account.model.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.canada.guusto.microservice.account.model.Account;

public interface AccountDao extends CrudRepository<Account, Long>{
	
	@Query("select a from Account a Where a.user.id = ?1")
	public Account getAccountByUserId(Long userId);
	
	@Transactional
	@Modifying
	@Query("update Account a set a.amount = ?1 Where a.id = ?2")
	public void updateAccount(Double amount, Long id);

}

package com.canada.guusto.microservice.codes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.canada.guusto.microservice.codes.model.Codes;

public interface CodesDao extends CrudRepository<Codes, Long> {

	@Query("select c from Codes c Where c.account.id=?1")
	public List<Codes> getCodesByAccountId(Long accountId);
	
}

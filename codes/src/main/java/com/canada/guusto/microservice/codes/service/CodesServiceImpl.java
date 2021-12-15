package com.canada.guusto.microservice.codes.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.guusto.microservice.codes.dao.CodesDao;
import com.canada.guusto.microservice.codes.model.Account;
import com.canada.guusto.microservice.codes.model.Codes;
import com.canada.guusto.microservice.codes.model.Merchants;
import com.canada.guusto.microservice.codes.pojo.CodesPojo;

@Service
public class CodesServiceImpl implements CodesService{
	
	@Autowired
	private CodesDao codesDao;

	@Override
	public List<CodesPojo> getCodesByAccountId(Long accountId) {
		return codesDao.getCodesByAccountId(accountId).stream().map(x -> toPojo(x)).collect(Collectors.toList());
	}

	@Override
	public CodesPojo generateCode(CodesPojo pojo) {
		return toPojo(codesDao.save(toModel(pojo)));
	}
	
	private CodesPojo toPojo(Codes codes) {
		CodesPojo pojo = new CodesPojo();
		pojo.setAccountId(codes.getAccount().getId());
		pojo.setAmount(codes.getAmount());
		pojo.setCode(codes.getCode());
		pojo.setId(codes.getId());
		pojo.setMerchantId(codes.getMerchant().getId());
		return pojo;
	}
	
	private Codes toModel(CodesPojo pojo) {
		Codes codes = new Codes();
		Merchants merchant = new Merchants();
		merchant.setId(pojo.getMerchantId());
		codes.setMerchant(merchant);
		Account account = new Account();
		account.setId(pojo.getAccountId());
		codes.setAccount(account);
		codes.setCode(generateCode());
		codes.setAmount(pojo.getAmount());
		return codes;
	}
	
	private String generateCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}

package com.canada.guusto.microservice.codes.service;

import java.util.List;

import com.canada.guusto.microservice.codes.pojo.CodesPojo;

public interface CodesService {

	public List<CodesPojo> getCodesByAccountId(Long accountId);
	public CodesPojo generateCode(CodesPojo pojo);
	
}

package com.canada.guusto.microservice.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canada.guusto.microservice.codes.pojo.CodesPojo;
import com.canada.guusto.microservice.codes.service.CodesService;

@RestController
public class CodesController {
	
	@Autowired
	private CodesService codesService;
	
	@GetMapping("/codes/account/{accountId}")
	public List<CodesPojo> getCodesByAccountId(@PathVariable Long accountId){
		return codesService.getCodesByAccountId(accountId);
	}
	
	@PostMapping("/codes/save/")
	public CodesPojo generateCode(@RequestBody CodesPojo code){
		return codesService.generateCode(code);
	}
	

}

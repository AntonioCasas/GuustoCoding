package com.canada.microservice.guusto.merchants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.canada.microservice.guusto.merchants.model.Merchants;
import com.canada.microservice.guusto.merchants.service.MerchantsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MerchantsController {
	
	@Autowired
	private MerchantsService merchantsService;
	
	@GetMapping("/merchants")
	public List<Merchants> getMerchants() {
		return merchantsService.getMerchants();	
	}
	
	@HystrixCommand(fallbackMethod="backupMethod")
	@GetMapping("/merchants/{id}")
	public Merchants getMerchantById(@PathVariable Long id) {
		return merchantsService.getMerchantById(id);
	}
	
	public Merchants backupMethod() {
		return new Merchants();
	}

}

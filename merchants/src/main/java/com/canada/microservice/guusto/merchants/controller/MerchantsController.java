package com.canada.microservice.guusto.merchants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.canada.microservice.guusto.merchants.model.Merchants;
import com.canada.microservice.guusto.merchants.service.MerchantsService;

@RestController
public class MerchantsController {
	
	@Autowired
	private MerchantsService merchantsService;
	
	@GetMapping("/merchants")
	public List<Merchants> getMerchants() {
		return merchantsService.getMerchants();	
	}
	
	@GetMapping("/merchants/{id}")
	public Merchants getMerchantById(@PathVariable Long id) {
		return merchantsService.getMerchantById(id);
	}

}

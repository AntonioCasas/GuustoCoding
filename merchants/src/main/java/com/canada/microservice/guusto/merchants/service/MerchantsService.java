package com.canada.microservice.guusto.merchants.service;

import java.util.List;

import com.canada.microservice.guusto.merchants.model.Merchants;

public interface MerchantsService {
	
	public List<Merchants> getMerchants();
	public Merchants getMerchantById(Long id);

}

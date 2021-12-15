package com.canada.microservice.guusto.merchants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.microservice.guusto.merchants.dao.MerchantsDao;
import com.canada.microservice.guusto.merchants.model.Merchants;

@Service
public class MerchantsServiceImpl implements MerchantsService {

	@Autowired
	private MerchantsDao merchantsDao;
	
	@Override
	public List<Merchants> getMerchants() {
		return (List<Merchants>) merchantsDao.findAll();
	}

	@Override
	public Merchants getMerchantById(Long id) {
		return merchantsDao.findById(id).orElse(null);
	}

}

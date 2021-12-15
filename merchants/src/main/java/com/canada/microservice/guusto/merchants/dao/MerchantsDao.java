package com.canada.microservice.guusto.merchants.dao;

import org.springframework.data.repository.CrudRepository;

import com.canada.microservice.guusto.merchants.model.Merchants;

public interface MerchantsDao extends CrudRepository<Merchants, Long>{

}

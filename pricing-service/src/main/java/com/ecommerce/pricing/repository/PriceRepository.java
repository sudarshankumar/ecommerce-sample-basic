package com.ecommerce.pricing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.pricing.Price;

public interface PriceRepository extends CrudRepository<Price, Long>{

	Price findByProductCode(String productCode);
	
	List<Price> findAll();
	
}

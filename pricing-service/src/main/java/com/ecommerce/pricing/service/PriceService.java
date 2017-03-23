package com.ecommerce.pricing.service;

import com.ecommerce.pricing.Price;

public interface PriceService {

	void save(Price price);
	
	Price findByProductCode(String productCode);
	
	void deleteByProductCode(String productCode);

}

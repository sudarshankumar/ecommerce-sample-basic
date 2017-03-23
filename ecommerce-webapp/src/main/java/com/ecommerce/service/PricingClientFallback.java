package com.ecommerce.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.pricing.Price;

@Service
public class PricingClientFallback implements PricingClient{

	@Override
	public ResponseEntity<String> save(Price price) {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> remove(String productCode) {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Price> findByProductCode(String productCode) {
		return new ResponseEntity<Price>(HttpStatus.NO_CONTENT);
	}

}

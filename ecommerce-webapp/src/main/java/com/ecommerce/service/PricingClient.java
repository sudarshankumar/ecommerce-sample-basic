package com.ecommerce.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.pricing.Price;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name = "pricing-service", fallback = PricingClientFallback.class)
public interface PricingClient {

	
	@RequestMapping(value="/price/save")
	@HystrixCommand(commandKey="savePrice")
	ResponseEntity<String> save(@RequestBody Price price);
	
	@RequestMapping(value = "/price/remove/{productCode}")
	@HystrixCommand(commandKey="findAllProducts")
	ResponseEntity<String> remove(@PathVariable("productCode") String productCode);
	
	@RequestMapping(value = "/price/findByProductCode/{code}")
	@HystrixCommand(commandKey="findByProductCode")
	ResponseEntity<Price> findByProductCode(@PathVariable("code") String productCode);
	
}

package com.ecommerce.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.catalogue.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name = "product-catalogue-service", fallback = ProductCatalogueClientFallback.class)
public interface ProductCatalogueClient {

	@RequestMapping(value="/product-catalogue/save")
	@HystrixCommand(commandKey="saveProduct")
	ResponseEntity<String> save(@RequestBody Product product);
	
	@RequestMapping(value="/product-catalogue/findAll")
	@HystrixCommand(commandKey="findAllProducts")
	ResponseEntity<List<Product>> findAllProducts();
	
	@RequestMapping(value="/product-catalogue/searchByCategory/{category}")
	@HystrixCommand(commandKey="searchByCategory")
	ResponseEntity<List<Product>> searchByCategory(@PathVariable("category") String category);
	
	@RequestMapping(value="/product-catalogue/remove/{code}")
	@HystrixCommand(commandKey="removeProduct")
	ResponseEntity<String> remove(@PathVariable("code") String code);
	
	@RequestMapping(value="/product-catalogue/findProduct/{code}")
	@HystrixCommand(commandKey="findProduct")
	ResponseEntity<Product> findProduct(@PathVariable("code") String code);
	
}

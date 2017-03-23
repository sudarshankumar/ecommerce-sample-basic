package com.ecommerce.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.catalogue.Product;

@Service
public class ProductCatalogueClientFallback implements ProductCatalogueClient{

	@Override
	public ResponseEntity<String> save(Product product) {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Product>> findAllProducts() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<Product>> searchByCategory(String category) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<String> remove(String code) {
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> findProduct(String code) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

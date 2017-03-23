package com.ecommerce.catalogue.service;

import java.util.List;

import com.ecommerce.catalogue.Product;

public interface ProductCatalogueService {

	Long save(Product product);
	
	List<Product> findAll();

	Product findProduct(String code);
	
	List<Product> searchByCategory(String category);

	void delete(String code);
	
}

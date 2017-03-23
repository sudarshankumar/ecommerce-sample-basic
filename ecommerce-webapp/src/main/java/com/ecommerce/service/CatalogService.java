package com.ecommerce.service;

import java.util.List;

import com.ecommerce.catalogue.Product;

public interface CatalogService {

	void saveProduct(Product product);
	
	void removedProduct(String productCode);
	
	List<Product> viewAllProducts();
	
	List<Product> searchProductsByCategory(String category);
	
	Product getPriceDetails(String productCode);
	
}

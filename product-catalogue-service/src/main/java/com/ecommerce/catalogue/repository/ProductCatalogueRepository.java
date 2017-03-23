package com.ecommerce.catalogue.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.catalogue.Category;
import com.ecommerce.catalogue.Product;

public interface ProductCatalogueRepository extends CrudRepository<Product, Long>{

	List<Product> findByCategory(Category category);
	
	List<Product> findAll();

	Product findByCode(String code);
	
}

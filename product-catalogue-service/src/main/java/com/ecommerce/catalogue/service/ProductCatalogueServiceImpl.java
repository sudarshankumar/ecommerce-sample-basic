package com.ecommerce.catalogue.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.ecommerce.catalogue.Category;
import com.ecommerce.catalogue.Product;
import com.ecommerce.catalogue.repository.ProductCatalogueRepository;

@Service
public class ProductCatalogueServiceImpl implements ProductCatalogueService {

	@Autowired
	private ProductCatalogueRepository productCatalogueRepository;

	@Override
	public Long save(Product product) {
		if (product != null) {
			try {
				Product _product = productCatalogueRepository.save(product);
				return _product.getId();
			} catch (JpaSystemException e) {
				throw new DuplicateProductException("Duplicate product found for product code: " + product.getCode());
			}
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		return productCatalogueRepository.findAll();
	}

	@Override
	public Product findProduct(String code) {
		/*long startTime = System.currentTimeMillis();
		long elapsedTime = 0;
		while(elapsedTime < 5000){
			elapsedTime = new Date().getTime() - startTime;
		}*/
		Product product = productCatalogueRepository.findByCode(code);
		if (product != null)
			return product;
		else
			throw new ProductNotFoundException("Product not found with code : " + code);
	}

	@Override
	public List<Product> searchByCategory(String category) {
		Category _category = Category.valueOf(category);
		return productCatalogueRepository.findByCategory(_category);
	}

	@Override
	public void delete(String code) {
		Product product = productCatalogueRepository.findByCode(code);
		if (product != null)
			productCatalogueRepository.delete(product);
		else
			throw new ProductNotFoundException("Product not found with code : " + code);
	}

}

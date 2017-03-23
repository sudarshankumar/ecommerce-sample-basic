package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.catalogue.Product;
import com.ecommerce.pricing.Price;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private ProductCatalogueClient productCatalogueService;
	
	@Autowired
	private PricingClient pricingService;
	
	@Override
	public void saveProduct(Product product) {
		if(product != null)
			productCatalogueService.save(product);
		if(product != null && product.getPrice() != null){
			product.getPrice().setProductCode(product.getCode());
			pricingService.save(product.getPrice());
		}
	}

	@Override
	public void removedProduct(String productCode) {
		productCatalogueService.remove(productCode);
		pricingService.remove(productCode);
	}

	@Override
	public List<Product> searchProductsByCategory(String category) {
		return productCatalogueService.searchByCategory(category).getBody();
	}

	@Override
	public Product getPriceDetails(String productCode) {
		Price price = pricingService.findByProductCode(productCode).getBody();
		Product product = productCatalogueService.findProduct(productCode).getBody();
		if(product != null)
			product.setPrice(price);
		return product;
	}

	@Override
	public List<Product> viewAllProducts() {
		List<Product> products = productCatalogueService.findAllProducts().getBody();
		return products;
	}

}

package com.ecommerce.catalogue.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.catalogue.Product;
import com.ecommerce.catalogue.service.DuplicateProductException;
import com.ecommerce.catalogue.service.ProductCatalogueService;
import com.ecommerce.catalogue.service.ProductNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Product Catalogue API")
public class ProductCatalogueController {
	
	@Autowired
	private ProductCatalogueService productCatalogueService;
	
	@RequestMapping(value = "/product-catalogue/save", method = RequestMethod.POST, consumes={"application/json"})
	@ApiOperation(value = "Save product information.")
	public ResponseEntity<String> save(@RequestBody Product product) {
		try{
			productCatalogueService.save(product);
			return new ResponseEntity<String>("", HttpStatus.CREATED);
		}catch(DuplicateProductException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_MODIFIED);
		}
	}
	
	@RequestMapping(value = "/product-catalogue/findAll", method = RequestMethod.GET, produces = {"application/json"})
	@ApiOperation(value = "View all products.")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productCatalogueService.findAll();
		if(products != null && !products.isEmpty())
			return new ResponseEntity<List<Product>>(products, getNoCacheHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/product-catalogue/findProduct/{code}", method = RequestMethod.GET, produces = {"application/json"})
	@ApiOperation(value = "Find a product by product code.")
	public ResponseEntity<Product> findProduct(@ApiParam(name="code", value="Product Code") @PathVariable("code") final String code){
		Product product = productCatalogueService.findProduct(code);
		try{
			return new ResponseEntity<Product>(product, getNoCacheHeaders(), HttpStatus.OK);
		}catch(ProductNotFoundException e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/product-catalogue/searchByCategory/{category}", method = RequestMethod.GET, produces = {"application/json"})
	@ApiOperation(value = "Search products by category.")
	public ResponseEntity<List<Product>> searchByCategory(@ApiParam(name="category", value="Category") @PathVariable("category") final String category){
		List<Product> products = productCatalogueService.searchByCategory(category);
		if(products != null && !products.isEmpty())
			return new ResponseEntity<List<Product>>(products, getNoCacheHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/product-catalogue/remove/{code}", method = RequestMethod.GET)
	@ApiOperation(value = "Remove a product by product code.")
	public ResponseEntity<String> deleteProduct(@ApiParam(name="code", value="Product Code") @PathVariable("code") final String code){
		try{
			productCatalogueService.delete(code);
			return new ResponseEntity<String>("", getNoCacheHeaders(), HttpStatus.OK);
		}catch(ProductNotFoundException e){
			return new ResponseEntity<String>(e.getMessage(), getNoCacheHeaders(), HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Generates HttpHeaders that have the no-cache set.
	 * 
	 * @return HttpHeaders.
	 */
	private HttpHeaders getNoCacheHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Cache-Control", "no-cache");
		return responseHeaders;
	}

}

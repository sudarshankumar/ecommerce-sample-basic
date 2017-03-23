package com.ecommerce.pricing.rest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pricing.Price;
import com.ecommerce.pricing.service.DuplicatePriceException;
import com.ecommerce.pricing.service.PriceNotFoundException;
import com.ecommerce.pricing.service.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Pricing API")
public class PriceController {
	
	private static final Logger LOG = Logger.getLogger(PriceController.class);
	
	@Autowired
	private PriceService priceService;
	
	@RequestMapping(value = "/price/save", method = RequestMethod.POST, consumes={"application/json"}, produces = {"application/json"})
	@ApiOperation(value = "Save price information of the product.")
	public ResponseEntity<String> save(@RequestBody Price price) {
		try{
			priceService.save(price);
			return new ResponseEntity<String>("", getNoCacheHeaders(), HttpStatus.CREATED);
		}catch(DuplicatePriceException e){
			return new ResponseEntity<String>(e.getMessage(), getNoCacheHeaders(), HttpStatus.NOT_MODIFIED);
		}
	}
	
	
	@RequestMapping(value = "/price/findByProductCode/{code}", method = RequestMethod.GET, produces = {"application/json"})
	@ApiOperation(value = "View product information for the given product code.")
	public ResponseEntity<Price> findProduct(@ApiParam(name="code", value="Product Code") @PathVariable("code") final String productCode) {
		LOG.log(Level.INFO, "Calling price API by product code...");
		try{
			Price price = priceService.findByProductCode(productCode);
			return new ResponseEntity<Price>(price, getNoCacheHeaders(), HttpStatus.OK);
		}catch(PriceNotFoundException e){
			return new ResponseEntity<>(null, getNoCacheHeaders(), HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/price/remove/{productCode}", method = RequestMethod.GET, produces = {"application/json"})
	@ApiOperation(value = "Remove price information for the given product code.")
	public ResponseEntity<String> deletePrice(@ApiParam(name="productCode", value="Product Code") @PathVariable("productCode") final String productCode){
		try{
			priceService.deleteByProductCode(productCode);
			return new ResponseEntity<String>("", getNoCacheHeaders(), HttpStatus.OK);
		}catch(PriceNotFoundException e){
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

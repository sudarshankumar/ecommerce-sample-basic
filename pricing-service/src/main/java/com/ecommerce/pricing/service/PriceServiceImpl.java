package com.ecommerce.pricing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.ecommerce.pricing.Price;
import com.ecommerce.pricing.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public void save(Price price) {
		if (price != null) {
			try {
				priceRepository.save(price);
			} catch (JpaSystemException e) {
				throw new DuplicatePriceException("Duplicate price found for product code: " + price.getProductCode());
			}
		}
	}

	@Override
	public Price findByProductCode(String productCode) {
		Price price = priceRepository.findByProductCode(productCode);
		if(price != null){
			return price;
		}else{
			throw new PriceNotFoundException("Price not found with product code : " + productCode);
		}
	}

	@Override
	public void deleteByProductCode(String productCode) {
		Price price = priceRepository.findByProductCode(productCode);
		if (price != null)
			priceRepository.delete(price);
		else
			throw new PriceNotFoundException("Price not found with product code : " + productCode);
	}

}

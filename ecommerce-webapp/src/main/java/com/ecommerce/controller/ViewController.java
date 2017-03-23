package com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.catalogue.Product;
import com.ecommerce.pricing.Price;
import com.ecommerce.service.CatalogService;

@Controller
public class ViewController {

	@Value("${pivotal.info.product.add.message}")
	private String productAddMessage;
	
	@Value("${pivotal.info.product.remove.message}")
	private String productRemovedMessage;
	
	@Value("${pivotal.info.price.not.found}")
	private String priceNotFound;
	
	@Value("${pivotal.info.product.not.found}")
	private String productNotFound;
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value="/")
	public String index(Model model){
		List<Product> products = catalogService.viewAllProducts();
		if(products == null)
			model.addAttribute("message", productNotFound);
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping(value="/newProduct")
	public String addProduct(Model model){
		Product product = new Product();
		product.setPrice(new Price());
		model.addAttribute("product", product);
		return "newProduct";
	}
	
	@RequestMapping(value="/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult bindingResult, 
			Model model){
		catalogService.saveProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping(value="/removeProduct")
	public String removeProduct(@RequestParam(value="productCode") String productCode){
		catalogService.removedProduct(productCode);
		return "redirect:/";
	}
	
	@RequestMapping(value="/search")
	public String removeProduct(){
		return "search";
	}
	
	@RequestMapping(value="/searchProduct")
	public String searchProduct(@RequestParam(value = "category") String category, Model model){
		List<Product> products = catalogService.searchProductsByCategory(category);
		if(products == null || products.isEmpty())
			model.addAttribute("message", productNotFound);
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping(value="/viewProductDetails")
	public String viewProductDetails(@RequestParam(value = "productCode") String productCode, Model model){
		Product product = catalogService.getPriceDetails(productCode);
		model.addAttribute("product", product);
		if(product == null)
			model.addAttribute("message", priceNotFound);
		return "productDetails";
	}
	
}

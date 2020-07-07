package com.ndew.work.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ndew.work.entity.Product;
import com.ndew.work.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products/{cust_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProductsByCustId(@PathVariable Integer cust_id) {
		
		List<Product> product  = new ArrayList<>();
	
		try {
			product = productService.getProductsByCustId(cust_id);
		}catch(Exception e) {
			System.out.println("Exception in ProductController : getProductsByCustId()"+e.getMessage());
		}
		
		return product;
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		
		Product result = null;
		
		try {
			result = productService.createProduct(product);
		}catch(Exception e) {
			System.out.println("Exception in ProductController : createProduct()"+e.getMessage());
		}
		
		return result;
	}

}

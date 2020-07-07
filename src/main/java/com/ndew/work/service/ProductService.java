package com.ndew.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndew.work.entity.Product;
import com.ndew.work.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		
		List<Product> product = new ArrayList<>();
		
		try {
			product = productRepo.findAll();
			
		}catch(Exception e) {
			System.out.println("Exception in ProductService : getAllProducts()"+e.getMessage());
		}

		return product;
	}
	
	public Product createProduct(Product product) {
		
		Product result = null;
		
		try {
			result = productRepo.save(product);
			
		}catch(Exception e) {
			System.out.println("Exception in ProductService : createProduct()"+e.getMessage());
		}
		
		return result;

	}
	
		public List<Product> getProductsByCustId(Integer custId) {
				
				List<Product> product = new ArrayList<>();
				
				try {
					product = productRepo.findByCustomerId(custId);
					System.out.println(product);
					
				}catch(Exception e) {
					System.out.println("Exception in ProductService : getProductsByCustId()"+e.getMessage());
				}
		
				return product;
			}

}

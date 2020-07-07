package com.ndew.work.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndew.work.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
	
	List<Product> findByCustomerId(Integer custId);

}

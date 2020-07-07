package com.ndew.work.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndew.work.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

	List<Customer> findByCustId(Integer custId);

	List<Customer> findByPhone(Long phone);
	
}

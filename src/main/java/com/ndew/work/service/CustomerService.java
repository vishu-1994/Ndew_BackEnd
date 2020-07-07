package com.ndew.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndew.work.entity.Customer;
import com.ndew.work.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepository;
	
	public List<Customer> getCustomersByCustId(Integer custId) {
		
		List<Customer> customer = new ArrayList<>();
		
		try {
			customer = customerRepository.findByCustId(custId);
			System.out.println(customer);
			
			//email util code
			
//			String fromAddr = "vishudhiman1994@gmail.com";
//			String[] recipientsTo = {"vishudhiman1994@gmail.com"};
//			String hostAddr = "smtp.gmail.com";
//			String subject = "This is for testing purpose";
//			String body = "Hello Team,"+"\n This mail is for testing purpose"+"\nThanks and Regards"+"\nVishu Dhiman";
//			String[] attachFiles = {"D:/IMG_5951.JPG"};
//			
//			EmailUtil email = new EmailUtil();
//			email.postMail(fromAddr, recipientsTo, subject, hostAddr, body, attachFiles);
			
			//till here
			
		}catch(Exception e) {
			System.out.println("Exception in CustomerService : getCustomersByCustId()"+e.getMessage());
		}

		return customer;
	}
	
	public Customer createCustomer(Customer customer) {
		
			Customer result = null;
			
			try {
				result = customerRepository.save(customer);
				
			}catch(Exception e) {
				System.out.println("Exception in CustomerService : createCustomer()"+e.getMessage());
			}
			
			return result;
	
		}
	
		public List<Customer> getCustomersByPhoneNumber(Long phone) {
				
				List<Customer> customer = new ArrayList<>();
				
				try {
					customer = customerRepository.findByPhone(phone);
					System.out.println(customer);
					
				}catch(Exception e) {
					System.out.println("Exception in CustomerService : getCustomersByPhoneNumber()"+e.getMessage());
				}
		
				return customer;
			}
		
		public List<Customer> getAllCustomers() {
			
			List<Customer> customer = new ArrayList<>();
			
			try {
				customer = customerRepository.findAll();
				
			}catch(Exception e) {
				System.out.println("Exception in CustomerService : getAllCustomers()"+e.getMessage());
			}
	
			return customer;
		}

}

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

import com.ndew.work.entity.Customer;
import com.ndew.work.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
			@RequestMapping(value = "/customers/{custId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Customer> getCustomersByCustId(@PathVariable Integer custId) {
				
				List<Customer> customer  = new ArrayList<>();
			
				try {
					customer = customerService.getCustomersByCustId(custId);
				}catch(Exception e) {
					System.out.println("Exception in CustomerController : getCustomersByCustId()"+e.getMessage());
				}
				
				return customer;
			}
			
			@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
			public Customer createCustomer(@RequestBody Customer customer) {
				
				Customer result = null;
				
				try {
					result = customerService.createCustomer(customer);
				}catch(Exception e) {
					System.out.println("Exception in CustomerController : createCustomer()"+e.getMessage());
				}
				
				return result;
			}
			
			@RequestMapping(value = "/loginCustomers/{phone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Customer> getCustomersByPhoneNumber(@PathVariable Long phone) {
				
				List<Customer> customer  = new ArrayList<>();
			
				try {
					customer = customerService.getCustomersByPhoneNumber(phone);
				}catch(Exception e) {
					System.out.println("Exception in CustomerController : loginCustomers()"+e.getMessage());
				}
				
				return customer;
			}
			
			@RequestMapping(value = "/allCustomers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Customer> getAllCustomers() {
				
				List<Customer> customer  = new ArrayList<>();
			
				try {
					customer = customerService.getAllCustomers();
				}catch(Exception e) {
					System.out.println("Exception in CustomerController : getAllCustomers()"+e.getMessage());
				}
				
				return customer;
			}
			
			@RequestMapping(value = "/loginCustomersActual/{phone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public Long loginCustomer(@PathVariable Long phone) {
				
				List<Customer> customer  = new ArrayList<>();
			
				try {
					customer = customerService.getCustomersByPhoneNumber(phone);
				}catch(Exception e) {
					System.out.println("Exception in CustomerController : loginCustomers()"+e.getMessage());
				}
				
				Long phoneno =(long) 0;
				for(Customer cust : customer) {
					phoneno = cust.getPhone();
				}
				
				return phoneno;
			}


}

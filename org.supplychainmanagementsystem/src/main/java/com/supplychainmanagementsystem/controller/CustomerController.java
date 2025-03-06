package com.supplychainmanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Customer;
import com.supplychainmanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(@RequestBody Customer customer)
	{
		return customerservice.addCustomer(customer);
	}

    @PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer)
	{
		return customerservice.updateCustomer(customer);
	}
    
    @GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		return customerservice.getAllCustomers();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@PathVariable int id)
	{
		return customerservice.deleteCustomerById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id)
	{
		return customerservice.getCustomerById(id);
	}
 
}


package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Customer;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	//add a customer
		public Customer addCustomer(Customer customer) {
			customerRepository.save(customer);
			return customer;
		}
		
		//update a customer
		public Customer updateCustomer(Customer customer) {
			customerRepository.save(customer);
			return customer;
		}
		
		//fetch all customers
		public List<Customer> getAllCustomers(){
			return  customerRepository.findAll();
		}
		
		//fetch by id
		public Optional<Customer> getCustomerById(int id) {
			return customerRepository.findById(id);
		}
		
		//delete using id
		public Optional<Customer> deleteCustomerById(int id){
			Optional<Customer> opt=customerRepository.findById(id);
			if(opt.isPresent()) {
				customerRepository.delete(opt.get());
				return opt;
			}else {
				throw new IdNotFoundException();
			}
		}
}

package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystem.dao.CustomerDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Customer;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.exception.NoRecordFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerdao;
	
	
		public ResponseEntity<ResponseStructure<Customer>> addCustomer(Customer customer){
		Customer recieve_customer=customerdao.addCustomer(customer);
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Customer added successfully");
		structure.setData(recieve_customer);
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer){
		Customer recieve_customer=customerdao.updateCustomer(customer);
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Customer updated successfully");
		structure.setData(recieve_customer);
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers(){
		List<Customer> customer_list=customerdao.getAllCustomers();
		ResponseStructure<List<Customer>> structure= new ResponseStructure<List<Customer>>();
		if(!customer_list.isEmpty()) {
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("All Customers fetched successfully");
		structure.setData(customer_list);
		return new ResponseEntity<ResponseStructure<List<Customer>>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int id){
		Optional<Customer> opt=customerdao.deleteCustomerById(id);
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		if(opt.isPresent()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Customer removed successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id){
		Optional<Customer> opt=customerdao.getCustomerById(id);
		ResponseStructure<Customer> structure= new ResponseStructure<Customer>();
		if(opt.isPresent()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Customer fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
}

package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystem.dao.CustomerDao;
import com.supplychainmanagementsystem.dao.OrdersDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Customer;
import com.supplychainmanagementsystem.entity.Orders;
import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.exception.NoRecordFoundException;
import com.supplychainmanagementsystem.repository.CustomerRepository;
import com.supplychainmanagementsystem.repository.OrdersRequest;
import com.supplychainmanagementsystem.repository.ProductRepository;


@Service
public class OrderService {

	@Autowired
	private OrdersDao orderdao;
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<ResponseStructure<Orders>> createOrder(OrdersRequest order){
		
		int customer_id=order.getCustomer_id();
		List<Integer> product_id=order.getProduct_id();
		Optional<Customer> customer=customerRepository.findById(customer_id);
		List<Product> product=productRepository.findAllById(product_id);
		
		if(!customer.isPresent()) {
			throw new IdNotFoundException();
		}
		if(product.isEmpty()) {
			throw new IdNotFoundException();
		}
		Orders orders=new Orders();
		
		//Optional<Customer> customer = customerdao.getCustomerById(order.getCustomer().getId());
		orders.setCustomer(customer.get());
		orders.setProducts(product);
		orders.setAmount(order.getAmount());
		orders.setStatus(order.getStatus());
		orders.setTrackingNumber(order.getTrackingNumber());
		orders.setDate(order.getDate());
		Orders recieveorder=orderdao.createOrder(orders);
		
		ResponseStructure<Orders> structure= new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Order creation is successfull");
		structure.setData(recieveorder);
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.CREATED);
	}
	
	//Updating Records
	public ResponseEntity<ResponseStructure<Orders>> updatingOrder(Orders order){
		
		Orders recieveorder;
		if(order.getId()!=0) {
			recieveorder = orderdao.getOrderById(order.getId()).get();
			if(order.getAmount()!=0) {
				recieveorder.setAmount(order.getAmount());
			}
			if(order.getDate()!=null) {
				recieveorder.setDate(order.getDate());
			}
			if(order.getStatus()!=null) {
				recieveorder.setStatus(order.getStatus());
			}
			if(order.getTrackingNumber()!=null) {
				recieveorder.setTrackingNumber(order.getTrackingNumber());
			}
			if(order.getCustomer()!=null) {
				recieveorder.setCustomer(order.getCustomer());
			}
			if(order.getProducts()!=null) {
				recieveorder.setProducts(order.getProducts());
			}
			
		}
		else {
			recieveorder = orderdao.updateOrders(order);
		}
		ResponseStructure<Orders> structure= new ResponseStructure<Orders>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Order creation is successfull");
		structure.setData(recieveorder);
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.CREATED);
	}
	
	//Fetching All Records
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		List<Orders> orderlist=orderdao.getAllOrders();
		ResponseStructure<List<Orders>> structure= new ResponseStructure<List<Orders>>();
		if(!orderlist.isEmpty()) {
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Orders fetched successfully");
		structure.setData(orderlist);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	//Deleting Record by Id
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(int id){
		Optional<Orders> opt=orderdao.deleteOrderById(id);
		ResponseStructure<Orders> structure= new ResponseStructure<Orders>();
		if(opt.isPresent()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order deleted successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	//Fetching Record by Id
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(int id){
		Optional<Orders> opt=orderdao.getOrderById(id);
		ResponseStructure<Orders> structure= new ResponseStructure<Orders>();
		if(opt.isPresent()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	//Fetching Record by Tracking Number
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(String tracking_number){
		Optional<Orders> opt=orderdao.getOrderByTrackingNumber(tracking_number);
		ResponseStructure<Orders> structure= new ResponseStructure<Orders>();
		if(opt.isPresent()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Order fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	//Fetching Record By Customer Id
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrdersByCustomerId(int id){
		List<Orders> order_list=orderdao.getOrdersByCustomerId(id);
		ResponseStructure<List<Orders>> structure= new ResponseStructure<List<Orders>>();
		if(!order_list.isEmpty()) {
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("All Orders fetched successfully");
		structure.setData(order_list);
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure,HttpStatus.OK);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
}

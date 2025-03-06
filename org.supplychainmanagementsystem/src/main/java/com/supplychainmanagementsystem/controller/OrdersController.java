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
import com.supplychainmanagementsystem.entity.Orders;
import com.supplychainmanagementsystem.repository.OrdersRequest;
import com.supplychainmanagementsystem.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Orders>> createOrder(@RequestBody OrdersRequest order)
	{
		return orderservice.createOrder(order);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(@RequestBody Orders order){
		return orderservice.updatingOrder(order);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		return orderservice.getAllOrders();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(@PathVariable int id)
	{
		return orderservice.deleteOrderById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id)
	{
		return orderservice.getOrderById(id);
	}
	
	@GetMapping("/{tracking_number}")
	public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(@PathVariable String tracking_number)
	{
		return orderservice.getOrderByTrackingNumber(tracking_number);
	}
	
	@GetMapping("/c_id/{id}")
	public ResponseEntity<ResponseStructure<List<Orders>>> getOrdersByCustomerId(@PathVariable int id)
	{
		return orderservice.getOrdersByCustomerId(id);
	}
}

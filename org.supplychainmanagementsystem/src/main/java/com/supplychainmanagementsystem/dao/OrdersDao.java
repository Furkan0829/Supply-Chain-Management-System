package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Orders;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.repository.OrdersRepository;
import com.supplychainmanagementsystem.repository.OrdersRequest;

@Repository
public class OrdersDao {

	@Autowired
	private OrdersRepository orderRepository;
	
		//create a Order
		public Orders createOrder(Orders order) {
			orderRepository.save(order);
			return order;
		}
		
	    //update order
		public Orders updateOrders(Orders order) {
			orderRepository.save(order);
			return order;
		}
		
		//fetch all orders
		public List<Orders> getAllOrders(){
			return  orderRepository.findAll();
		}
		
		//fetch order by id
		public Optional<Orders> getOrderById(int id) {
			return orderRepository.findById(id);
		}
		
		//delete order by id
		public Optional<Orders> deleteOrderById(int id){
			Optional<Orders> opt=orderRepository.findById(id);
			if(opt.isPresent()) {
				orderRepository.delete(opt.get());
				return opt;
			}else {
				throw new IdNotFoundException();
			}
		}
		
		//fetch order by Tracking number
		public Optional<Orders> getOrderByTrackingNumber(String tracking_number) {
			return orderRepository.findByTrackingNumber(tracking_number);
		}
		
		//get orders by customer id //check it by adding order and cutomr id wirh it 
		public List<Orders> getOrdersByCustomerId(int id){
			return orderRepository.findByCustomerId(id);
		}
}

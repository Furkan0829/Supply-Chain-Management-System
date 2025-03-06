package com.supplychainmanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supplychainmanagementsystem.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	Optional<Orders> findByTrackingNumber(String tracking_number);

	List<Orders> findByCustomerId(int id);

}

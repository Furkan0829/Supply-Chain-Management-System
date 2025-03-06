package com.supplychainmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychainmanagementsystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

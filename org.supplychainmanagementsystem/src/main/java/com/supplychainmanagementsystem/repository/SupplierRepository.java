package com.supplychainmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychainmanagementsystem.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}

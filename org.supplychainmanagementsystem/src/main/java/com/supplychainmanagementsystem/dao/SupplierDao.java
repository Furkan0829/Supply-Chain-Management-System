package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.repository.SupplierRepository;

@Repository
public class SupplierDao {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//save supplier
	public Supplier saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//update supplier
	public Supplier updateSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//get all suppliers
	public List<Supplier> getAllSuppliers(){
		List<Supplier> supplierList=supplierRepository.findAll();
		return supplierList;
	}
	
	//get one supplier by id
	public Optional<Supplier> getSupplierById(int id) {
		Optional<Supplier> opt=supplierRepository.findById(id);
			return opt;
	}
	//delete supplier
	public Optional<Supplier> deleteSupplier(int id) {
		Optional<Supplier> opt=supplierRepository.findById(id);
		if(opt.isPresent()) {
			supplierRepository.delete(opt.get());
			return opt;
		}
		else {
			throw new com.supplychainmanagementsystem.exception.IdNotFoundException();
		}
	}
	
}
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
import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.service.ProductService;
import com.supplychainmanagementsystem.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Supplier>> addSupplier(@RequestBody Supplier supplier){
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> getSupplier(@PathVariable int id){
		return supplierService.getSupplierById(id);
	}
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers(){
		return supplierService.getAllSuppliers();
	}
	@PutMapping()
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@RequestBody Supplier supplier){
		return supplierService.updateSupplier(supplier);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(@PathVariable int id){
		return supplierService.deleteSupplierById(id);
	}
	
	@GetMapping("/supplierid/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(@PathVariable int id){
		return productService.getProductBySupplierId(id);
	}
	
}

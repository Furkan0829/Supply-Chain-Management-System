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
import com.supplychainmanagementsystem.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getProducts(){
		return productservice.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProduct(@PathVariable int id){
		return productservice.getProductById(id);
	}
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return productservice.saveProduct(product);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updatingProduct(@RequestBody Product product){
		return productservice.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProducts(@PathVariable int id){
		return productservice.deleteProductById(id);
	}
	
	
}

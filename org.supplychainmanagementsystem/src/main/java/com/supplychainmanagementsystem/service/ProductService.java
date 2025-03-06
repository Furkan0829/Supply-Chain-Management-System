package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystem.dao.ProductDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.exception.NoRecordFoundException;
import com.supplychainmanagementsystem.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product recieve_product=productDao.saveProduct(product);
		ResponseStructure<Product> structure = new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Product Added Successfully");
		structure.setData(recieve_product);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
		Optional<Product> opt = productDao.getProductById(id);
		if(opt.isPresent()) {
			ResponseStructure<Product> structure = new ResponseStructure<Product>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Supplier found");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		List<Product> list = productDao.getAllProducts();
		if(!list.isEmpty()) {
			ResponseStructure<List<Product>> structure = new ResponseStructure<List<Product>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Products are found");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		Product recieve_Product=productDao.updateProduct(product);
		ResponseStructure<Product> structure = new ResponseStructure<Product>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Product Updated Successfully");
		structure.setData(recieve_Product);
		
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int id){
		Optional<Product> opt = productDao.deleteProduct(id);
		if(opt.isPresent()) {
			ResponseStructure<Product> structure = new ResponseStructure<Product>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Product deleted");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(int id){
		List<Product> productList=productDao.getProductBySupplierId(id);
		ResponseStructure<List<Product>> structure= new ResponseStructure<List<Product>>();
		if(!productList.isEmpty()) {
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Products fetched successfully");
		structure.setData(productList);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
}

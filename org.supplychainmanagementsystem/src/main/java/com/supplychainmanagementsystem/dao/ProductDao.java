package com.supplychainmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.exception.NoRecordFoundException;
import com.supplychainmanagementsystem.repository.ProductRepository;
import com.supplychainmanagementsystem.repository.SupplierRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//save supplier
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	//update supplier
	public Product updateProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	//get all suppliers
	public List<Product> getAllProducts(){
		List<Product> productList=productRepository.findAll();
		return productList;
	}
	
	//get one supplier by id
	public Optional<Product> getProductById(int id) {
		Optional<Product> opt=productRepository.findById(id);
			return opt;
	}
	//delete supplier
	public Optional<Product> deleteProduct(int id) {
		Optional<Product> opt=productRepository.findById(id);
		if(opt.isPresent()) {
			productRepository.delete(opt.get());
			return opt;
		}
		else {
			throw new com.supplychainmanagementsystem.exception.IdNotFoundException();
		}
	}
	
	public List<Product> getProductBySupplierId(int id) {
		Optional<Supplier> opt= supplierRepository.findById(id);
		
		if(opt.isPresent()) {
			return opt.get().getProducts();
		}else {
			throw new NoRecordFoundException();
		}
		
	}
}

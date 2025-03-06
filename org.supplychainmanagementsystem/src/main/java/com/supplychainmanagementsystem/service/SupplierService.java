
package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.supplychainmanagementsystem.dao.SupplierDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Supplier;
import com.supplychainmanagementsystem.exception.IdNotFoundException;
import com.supplychainmanagementsystem.exception.NoRecordFoundException;
import com.supplychainmanagementsystem.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierDao supplierDao;

	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier) {
		Supplier recieve_supplier=supplierDao.saveSupplier(supplier);
		ResponseStructure<Supplier> structure = new ResponseStructure<Supplier>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Supplier Added Successfully");
		structure.setData(recieve_supplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id){
		Optional<Supplier> opt = supplierDao.getSupplierById(id);
		if(opt.isPresent()) {
			ResponseStructure<Supplier> structure = new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Supplier found");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers(){
		List<Supplier> list = supplierDao.getAllSuppliers();
		if(!list.isEmpty()) {
			ResponseStructure<List<Supplier>> structure = new ResponseStructure<List<Supplier>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Suppliers found");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier) {
		Supplier recieve_supplier=supplierDao.updateSupplier(supplier);
		ResponseStructure<Supplier> structure = new ResponseStructure<Supplier>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Supplier Updated Successfully");
		structure.setData(recieve_supplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(int id){
		Optional<Supplier> opt = supplierDao.deleteSupplier(id);
		if(opt.isPresent()) {
			ResponseStructure<Supplier> structure = new ResponseStructure<Supplier>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Supplier deleted");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
}

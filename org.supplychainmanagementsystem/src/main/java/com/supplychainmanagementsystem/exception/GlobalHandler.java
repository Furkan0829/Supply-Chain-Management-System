package com.supplychainmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.supplychainmanagementsystem.dto.ResponseStructure;


@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handlerINFE(IdNotFoundException exception){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No records found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NameNotFound.class)
	public ResponseEntity<ResponseStructure<String>> nameHandler(NameNotFound exception){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No records found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noRecordHandler(NoRecordFoundException exception){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No records found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
}

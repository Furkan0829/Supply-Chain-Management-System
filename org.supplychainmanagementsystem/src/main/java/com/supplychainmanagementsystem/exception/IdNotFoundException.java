package com.supplychainmanagementsystem.exception;


public class IdNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Entered Id is not present";
		
	}
}

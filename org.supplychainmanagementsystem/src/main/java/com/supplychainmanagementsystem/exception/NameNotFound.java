package com.supplychainmanagementsystem.exception;

public class NameNotFound extends RuntimeException {

	@Override
	public String getMessage() {
		return "Name is not present in the table";
	}
}

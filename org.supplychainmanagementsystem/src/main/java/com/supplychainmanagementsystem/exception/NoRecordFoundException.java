package com.supplychainmanagementsystem.exception;

public class NoRecordFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No records are found";
	}
}

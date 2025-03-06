package com.supplychainmanagementsystem.repository;

import java.time.LocalDate;
import java.util.List;

public class OrdersRequest {
private int customer_id;
private List<Integer> product_id;
private String status;
private double amount;
private String trackingNumber;
private LocalDate date;
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public List<Integer> getProduct_id() {
	return product_id;
}
public void setProduct_id(List<Integer> product_id) {
	this.product_id = product_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getTrackingNumber() {
	return trackingNumber;
}
public void setTrackingNumber(String trackingNumber) {
	this.trackingNumber = trackingNumber;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
}

package com.managenament_sys.dto;

import java.sql.Date;

public class ProductDTO {
	
	private String name;
	private double price;
	private Date date;
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return this.date;
	}
	
	public void setPrice(Date date) {
		this.date = date;
	}
}

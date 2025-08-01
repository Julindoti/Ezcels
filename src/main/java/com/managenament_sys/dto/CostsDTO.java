package com.managenament_sys.dto;

import java.sql.Date;

public class CostsDTO {

	 private String name;
	 private int quantity;
	 private double value;
	 private float weight;
	 private Date date;


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getWeight(){
		return weight;
	}
	public void setWeight(float weight){
		this.weight= weight;
		
	}
}
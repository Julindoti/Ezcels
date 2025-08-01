package com.managenament_sys.dto;

public class MonthlyDataDTO {

	private final String month;
	private final int quantity;
	
	public MonthlyDataDTO(String month, int quantity) {
		this.month = month;
		this.quantity = quantity;
		
	}
	
	public String getMonth() {return month;}
	
	public int getQuantity() {return quantity;}
}

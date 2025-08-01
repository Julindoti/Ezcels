package com.managenament_sys.service;

import org.springframework.stereotype.Service;

@Service
public class Sheetindex {

	private String path;
	
	private String sheetName;
	

	public void setSheet (String sheetName) {
		
		this.sheetName = sheetName;
	} 
	public String  getSheet() {return sheetName;}
	
	public void setPath(String path) {this.path= path;}
	public String getPath() {return path;}
	
}

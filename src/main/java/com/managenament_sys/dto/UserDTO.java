package com.managenament_sys.dto;

import com.managenament_sys.modules.Levels;

public class UserDTO {
	private String name;
	private String password;
	private String email;
	private Levels level;
	
	
	public UserDTO() {}
	public UserDTO (String email, String password){
		this.email= email;
		this.password = password;
		
	}
	public void setLevel(Levels level) {
		this.level = level;
	}
	
	public Levels getLevel() {
		return this.level;
	}
	
	public String getUsername() {
		return this.name;
	}
	
	public void setUsername(String name) {
		this.name = name;
	}
	
	public String getUseremail() {
		return this.email;		
	}
	
	public void setUseremail(String email) {
		this.email = email;	
	}
	
	public String getUserpassword() {
		return this.password;
	}
	
	public void setUserpassword(String password) {
		this.password = password;	
	}


}

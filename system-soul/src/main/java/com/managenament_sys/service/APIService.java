package com.managenament_sys.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService{
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public List<Object> fetchUser(){
		String url= "https://sheets.googleapis.com/v4/spreadsheets/1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM/values/EZ?key=AIzaSyDcti4PcrrgE4BBc9MSSMHaeJ_v_qCRTgc";
		Object[] response= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(response);
		
	}
	
	public boolean IsUP() {
		try {
			ResponseEntity<String> response = restTemplate.getForEntity("https://sheets.googleapis.com/v4/spreadsheets/1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM/values/EZ?key=AIzaSyDcti4PcrrgE4BBc9MSSMHaeJ_v_qCRTgc", String.class);
			return response.getStatusCode().is2xxSuccessful();
		}catch (Exception e) {return false;}
		
		
			}
}
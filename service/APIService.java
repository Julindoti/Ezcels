package com.managenament_sys.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class APIService{
	
	private RestTemplate restTemplate= new RestTemplate();
		
	 public List<Object> fetchUser(){
		String url= "https://sheets.googleapis.com/v4/spreadsheets/1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM/values/EZ?key=AIzaSyDcti4PcrrgE4BBc9MSSMHaeJ_v_qCRTgc";
		Object[] response= restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(response);
		
		
	 }
	
	public boolean IsUP() {
		try {
			ResponseEntity<String> response = restTemplate.getForEntity("https://sheets.googleapis.com/v4/spreadsheets/1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM/values/Sheet?key=AIzaSyDcti4PcrrgE4BBc9MSSMHaeJ_v_qCRTgc", String.class);
			return response.getStatusCode().is2xxSuccessful();
		}catch (Exception e) {return false;}
		
		
	}
}

/*	private final WebClient webClient;
		
	public void ApiService(WebClient.Builder webClientBuilder) {
		
		this.webClient= webClientBuilder.baseUrl("https://sheets.googleapis.com/v4/spreadsheets/1AEZ82yV_Rgo_z37NusT6gi9CZsp79pUFOfpqsHc09yg/values/Sheet1!A1:B2").build();
	}
	public String APICall(){
		return webCLient.get()
			    .path("/v4/spreadsheets/")
				.uri()
				
 */		
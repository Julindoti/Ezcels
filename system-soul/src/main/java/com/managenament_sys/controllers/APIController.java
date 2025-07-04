package com.managenament_sys.controllers;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.managenament_sys.service.*;
@RestController
@RequestMapping("/sheets_api") 
public class APIController{
	private final APIService apiService;
	
	public APIController(APIService apiService){
		this.apiService= apiService;
		
	}
	@GetMapping("/sheets")
	public List<Object> getSheetsAPI(){
		return apiService.fetchUser();
		
		
	}
	@GetMapping("/testing")
	public boolean  getIsOnline(){
		return apiService.IsUP();
	}
	}

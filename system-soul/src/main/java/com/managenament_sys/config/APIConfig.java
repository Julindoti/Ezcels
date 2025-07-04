package com.managenament_sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class APIConfig{
	@Bean
	public WebClient.Builder  webCLientBuilder(){
		return WebClient.builder();		
		
	}
	
	 	
	
}
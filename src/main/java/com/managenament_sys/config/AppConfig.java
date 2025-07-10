package com.managenament_sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.managenament_sys.mapper.ProductMapper;
import com.managenament_sys.repository.ProductRepository;
import com.managenament_sys.service.ProductService;
import com.managenament_sys.service.ProductServiceBrute;

@Configuration
public class AppConfig {
	
	@Bean
	public ProductService service(ProductRepository repo ,ProductMapper mapper ) {
		return new ProductServiceBrute(repo, mapper);
		
	}
    
}

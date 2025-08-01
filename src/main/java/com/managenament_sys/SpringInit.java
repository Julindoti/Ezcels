package com.managenament_sys;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringInit  {
	
	public static SpringApplicationBuilder SpringBuild(Class clas) {
		
		SpringApplicationBuilder builder= new SpringApplicationBuilder(clas);
		builder.headless(false);
		builder.web(WebApplicationType.NONE);
		return builder;
		
	}
}

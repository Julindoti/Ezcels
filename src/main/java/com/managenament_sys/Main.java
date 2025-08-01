package com.managenament_sys;

import java.io.IOException;


import javafx.application.*;
import javafx.stage.Stage;



import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


//@ComponentScan(basePackages = {"com.managenament_sys.controllers"})
public class Main extends Application {
	
	private ConfigurableApplicationContext context;
	
	
	@Override
	public void init() throws Exception {
		
        SpringApplicationBuilder builder =  SpringInit.SpringBuild(SpringInit.class);
		context= builder.run();
				
	}
	@Override
	public void start (Stage primaryStage){

		context.publishEvent(new LoadEventInit(primaryStage));
				
		
	}
	@Override 
	public void stop() throws Exception{
		context.close();
		Platform.exit();
	}

	public static void main(String[] args) throws IOException {
 
			Application.launch(args);		
	}
}




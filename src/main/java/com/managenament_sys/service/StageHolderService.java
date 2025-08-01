package com.managenament_sys.service;

import org.springframework.stereotype.Service;

import javafx.stage.Stage;

@Service
public class StageHolderService {

	private Stage primaryStage;
	
	public Stage getStage() {
		
		if(primaryStage == null ){
		throw new IllegalStateException("Primary Stage wasn't initialize yet");	
		}		
	
		return this.primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
	       this.primaryStage = primaryStage;
	}
	
	
}

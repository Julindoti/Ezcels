package com.managenament_sys;

import javafx.stage.Stage;

@SuppressWarnings("serial")
public class LoadEventInit extends org.springframework.context.ApplicationEvent{


 public LoadEventInit(Stage stage) {
	super(stage);

	}

 public Stage getStage () {
			
     return ((Stage) getSource());
			
	}
		
		
}

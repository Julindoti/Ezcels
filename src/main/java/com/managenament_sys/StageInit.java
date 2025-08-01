package com.managenament_sys;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.managenament_sys.service.NavigationService;
import com.managenament_sys.service.StageHolderService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


@Component
public class StageInit implements ApplicationListener<LoadEventInit>{
		
		
	@Value("classpath:/fxml/Dashboard.fxml")
	private Resource  loginResource;

	@Value("classpath:/fxml/css/corestyle.css")
	private Resource cssResource;
	
    
	private ApplicationContext appcontext;	
	
	private final NavigationService navservice;	
	
	private Stage stage;
	private final StageHolderService primaryStage;
	
	
	private  StageInit(ApplicationContext appcontext , NavigationService navservice, StageHolderService primaryStage) {
		this.appcontext = appcontext;
		this.navservice =  navservice;
		this.primaryStage =  primaryStage;
		
	}

		
	@Override
	public void onApplicationEvent(LoadEventInit event) {
		System.out.println("<---------------------------------->");
		System.out.println("logged onApplicationEvent class");
         try {
        	stage = event.getStage();
    		Scene scene = new Scene(new Pane(),900 , 650.0);
    		navservice.setMainScene(scene);
    		navservice.navigate(loginResource);
    		System.out.println("Parent root loaded");
    	    
    		//anchor pane left 0 e anchor pane right 500 -> medidas boas para janela 
    	    //não maximizada
    		scene.getStylesheets().add(cssResource.getURL().toExternalForm());
    		stage.setScene(scene); 
    		stage.setResizable(true);
    	    stage.setMaximized(false);
    		stage.setTitle("Ezcels- Dashboard");
    		System.out.println("Stage tittle setted correctly");
    		stage.show();
    		primaryStage.setPrimaryStage(stage);
    		System.out.println(primaryStage.getStage());
    		
    		System.out.println("Stage on");
            System.out.println("<---------------------------------->");        	 	
        	 
         }catch(Exception e ) { 
        	 System.err.println("FATAL ERROR IN onApplicationEvent class");
        	 e.printStackTrace();}  		
	   }
	}

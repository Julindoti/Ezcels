package com.managenament_sys.service;

import java.io.IOException;
import java.net.URL;
import java.util.Stack;


import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

@Service 
public class NavigationService {

	ApplicationContext context;
	private final Stack<Parent> history= new Stack<>();
	private Scene mainscene;
	
	
	public NavigationService(ApplicationContext context){
		
		this.context = context;	
	}
	public void setMainScene(Scene mainscene){
		
		this.mainscene = mainscene;
	}
	public Scene getMainScene() {return this.mainscene;}
	
	public void navigate(Resource path) {
		try {
	
		if(mainscene.getRoot() != null){
			history.push(mainscene.getRoot());
		}
		
	    Parent root = LoadRoot(path); 
		mainscene.setRoot(root);
		
		}catch(IOException e ){e.printStackTrace();}
		
	}
	private Parent LoadRoot (Resource path) throws IOException{
		
		Resource fxmlURL = path;
		if(fxmlURL == null ){		
			System.out.println("ERROR IN NAVIGATION CLASS: THE URL IS NULL");	
		}else {
		 FXMLLoader loader = new FXMLLoader(fxmlURL.getURL());
		 loader.setControllerFactory(context::getBean);

		return loader.load();
		}
		return null;
	}
	public void back(){
		
		if(history.isEmpty()){
			
			System.out.println("history is empty");
			return;
		}
		Parent pastRoot = history.pop();
		mainscene.setRoot(pastRoot);
	}
}
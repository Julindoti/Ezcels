	package com.managenament_sys.UI_controllers;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.managenament_sys.modules.SheetCells;
import com.managenament_sys.service.FilePickerService;

import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;



@Component
public class FXMLController{
    
	        @Autowired
	        private FilePickerService picker;
	        @FXML 
	        private TextField requestIn;
	        @FXML 
	        private Button requestSub;
	        @FXML 
	        private VBox containerInput;
	    	@FXML
	    	private Label Waitmessage;
	    	@FXML 
	    	private TableView<?> produtosTable;
	    	@FXML 
	    	private TableView<?> gastosTable;
	    	@FXML 
	    	private TableView<?> vendasTable;
	    	@FXML
	    	private TableView<?> usersTable;
	    	@FXML
	    	private Tab produtoTab;
	    	@FXML 
	    	private TabPane tabPane;
	    	@FXML
	    	private Button open_file_btn;
	    	@FXML 
	    	private TableView<ObservableList<SheetCells>> tableView;
	    	
	    	
	    	
	      @FXML
	    	public void newTab() {
	    	  try {
	    		FXMLLoader loaderTabs = new FXMLLoader(getClass().getResource("/fxml/Tabs.fxml"));
	    		FXMLLoader loaderStartPage= new FXMLLoader(getClass().getResource("/fxml/StartPage.fxml"));
	    		FXMLLoader loaderToolBar= new FXMLLoader(getClass().getResource("/fxml/Toolbar.fxml"));
	    		FXMLLoader loaderSideBar= new FXMLLoader(getClass().getResource("/fxml/Sidebar.fxml"));
	    		Parent root = loaderTabs.load();
	    		Parent root2 = loaderStartPage.load();
	    		Parent root3 = loaderToolBar.load();
	    		FXMLController controller = loaderTabs.getController();
	    		
	    		Tab tab=controller.produtoTab;
	    		TabPane pane= controller.tabPane;
		    	pane.getSelectionModel().select(tab);
		    	
	    	  }catch(IOException e) {e.printStackTrace();}
	    	}	
         @FXML 
         public void LoginConfirm() {
        	 
        	 try {
        		 FXMLLoader authLoadPage = new FXMLLoader(getClass().getResource("LoginModal.fxml"));
        		 Parent root= authLoadPage.load();
        		 
        		 
        		 
        		 
        	 }catch(IOException e){e.printStackTrace();}
        	 
        	 
         }
      
//  
//      public void value(Label Waitmessage) {
//    	    Waitmessage= Controller.Waitmessage;
//	    	FadeTransition fade= new FadeTransition(Duration.seconds(2), Waitmessage);
//	    	fade.setFromValue(0.0);
//	    	fade.setToValue(1.5);
//	    	fade.play();
//      	}
	
}	 

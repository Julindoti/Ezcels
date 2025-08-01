package com.managenament_sys.UI_controllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.managenament_sys.modules.SheetCells;
import com.managenament_sys.service.FilePickerService;
import com.managenament_sys.service.NavigationService;
import com.managenament_sys.service.StageHolderService;
import com.managenament_sys.service.WorkbookService;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class DashboardController {

	@Value("classpath:/fxml/Dashboard.fxml")
	Resource LoaderResource;
	@Value("classpath:/fxml/MainPage.fxml")
	Resource MainResource;
	private ApplicationContext context;
	@Autowired
	private StageHolderService primaryStage;
	@Autowired
	private NavigationService navigate;
	@Autowired
	private MainPageController mainpage;
	@Autowired
	private FilePickerService picker;
	@Autowired 
	private WorkbookService service;
	
	
	@FXML 
	public void StartSheets(ActionEvent event) throws IOException{
       	
		    navigate.navigate(MainResource);
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/MainPage.fxml"));
            Parent root = loader.load();
            Stage stage = primaryStage.getStage();
            Scene scene =navigate.getMainScene();
            stage.setHeight(900.0);
            stage.setWidth(1400.0);
            stage.setTitle("Ezcels - Planilhas");
            stage.setResizable(true);
            stage.setFullScreen(false);
            stage.show();
	       }
	@FXML
	void LogOut(){Platform.exit();}
}
	

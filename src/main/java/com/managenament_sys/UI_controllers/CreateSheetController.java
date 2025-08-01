package com.managenament_sys.UI_controllers;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.managenament_sys.service.FileHolder;
import com.managenament_sys.service.NavigationService;
import com.managenament_sys.service.Sheetindex;
import com.managenament_sys.service.StageHolderService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
public class CreateSheetController {

	@Value("classpath:/fxml/modals/createSheet.fxml")
	Resource CreateResource;
	
    
	@Autowired 
	private FileHolder holder;
	@Autowired
	private Sheetindex sheetname;
	@Autowired
	private WorkbookReader reader;
	@Autowired
	private NavigationService navigate;
	@Autowired
	private StageHolderService primaryStage;
	@FXML
	private TextField user_sheetname;
	
    
	
	void handleInitEvent(ActionEvent event) throws IOException{
		
		String path= sheetname.getPath();
		System.out.println(sheetname.getPath());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/modals/createSheet.fxml"));
		VBox page = loader.load();
		page.setAlignment(Pos.CENTER);
	    Scene scene = new Scene(page, 347,311);
		Stage modalStage = new Stage();
		modalStage.setTitle("Adicionar planilhas");
		modalStage.setScene(scene);
		modalStage.initModality(Modality.WINDOW_MODAL);
		modalStage.initOwner(primaryStage.getStage());
		modalStage.show();
			
		
		
	}
	@FXML
	void createSheet (ActionEvent event) throws IOException{
		String input=user_sheetname.getText();
		File file = holder.getCurrentFile();
		if(input == null) {
			
			System.out.println("Input invalid, porfavor tente novamente");
			
		}
		reader.createNewSheet(file, input);
	}
}

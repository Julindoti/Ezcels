package com.managenament_sys.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.managenament_sys.StageInit;

import javafx.stage.FileChooser;

@Component 
public class FilePickerService {

	private String file_name;
	public void setFilename(String name) {this.file_name = name;}
	public String getFilename() {return this.file_name;}
	
	@Autowired
	private StageHolderService primaryStage;
	
	  public String PickerAct() {
	        FileChooser filepicker = new FileChooser();
	        filepicker.setTitle("Arquivo Excel");
	        
	        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Escolha arquivos Excel (*.xlsx, *.xls)"
	        		, "*.xlsx", "*.xls");
	        
	        filepicker.setSelectedExtensionFilter(filter);
	    
	        String home = System.getProperty("user.home");
	        File initialDir= new File(home);
	        filepicker.setInitialDirectory(initialDir);

	       System.out.println("");
		  File selectedFile = filepicker.showOpenDialog(primaryStage.getStage());
		  setFilename(filepicker.getInitialFileName());
		  System.out.println(file_name);
		  System.out.println( "File localized in:"+" " + selectedFile.getAbsolutePath());
      
		 return selectedFile.getAbsolutePath();
	        
	  }
		
}

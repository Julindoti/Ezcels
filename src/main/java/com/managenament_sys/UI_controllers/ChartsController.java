package com.managenament_sys.UI_controllers;



import java.beans.EventHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.managenament_sys.service.NavigationService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

@Component
public class ChartsController {

	@Value("classpath:/fxml/modals/Chartsmodal.fxml")
	Resource ModalResource;
	
	@Autowired
	private MainPageController mainPage;
	@Autowired
	private NavigationService navigate;
	@FXML
	private Button back_btn;

	@FXML
	private Label month;
	
	@FXML
	public void openCharts(MouseEvent event){
		
		try {
         		System.out.println(mainPage.getData());
				
		}catch(Exception e) {e.printStackTrace();}	
	}
	@FXML
	void initialize(){
	
		
		String currentMonth= MonthTime();
		month.setText(currentMonth);
		
		back_btn.setOnAction(event -> goBack());
		
	}
	
	
	public  void goBack() {
		
		navigate.back();
		
	}
	private String MonthTime() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", new Locale("pt", "BR"));
	
		String currentMonth = date.format(formatter);
		
		return currentMonth;
	}
}

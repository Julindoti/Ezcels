package com.managenament_sys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.managenament_sys.service.WorkbookService;


@Component 
public class WorkbookController {

		
		private  WorkbookService service;
        private String filepath;
        
        public WorkbookController(String filepath, WorkbookService service){
        	this.filepath = filepath;
        	this.service= service;
        }
        public WorkbookController() {}     
		
		public String FileRead(String filepath){
			     return null;
//		        return service.read(filepath);
		}
		
		

}

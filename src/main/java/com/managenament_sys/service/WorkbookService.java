package com.managenament_sys.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.managenament_sys.modules.SheetCells;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@Component
public class WorkbookService {
	
	@Autowired
	private  Sheetindex teste;
	@Autowired
	private static FilePickerService  picker;
	
	private String path;
	
	public WorkbookService(String path) {
		this.path = path;
		
	}
	public WorkbookService() {}	
	
	
	public static SheetCells read (String path) {	

		try {
			
	   FileInputStream file = new FileInputStream(new File(path));
	   XSSFWorkbook workbook = new XSSFWorkbook(file);
	   int numSheets = workbook.getNumberOfSheets();
	   int i=0;	
	  while(numSheets >i) {
		 System.out.println("<-------------------------------------->");
		 String name= workbook.getSheetName(i);
		 XSSFSheet sheet = workbook.getSheetAt(i);
		 Iterator<Row> rowIterator = sheet.iterator();
		 System.out.println("SHEET NAME:"+ " "+ name);
		 System.out.println("/--------------------------------------/");	
		 
	   while(rowIterator.hasNext()) {
		   Row row = rowIterator.next();
		   Iterator<Cell> cellIterator = row.cellIterator();
		   
		   while (cellIterator.hasNext()) {
			   
			   Cell cell= cellIterator.next();
			  
	
			   switch (cell.getCellType()){
			   
			   case NUMERIC:
				   System.out.println(cell.getNumericCellValue());
				   
					 return new SheetCells(CellType.NUMERIC, cell.getNumericCellValue());
			   case STRING:
				    System.out.println(cell.getStringCellValue());
				   break;
				  
			   case BOOLEAN:
				   System.out.println(cell.getBooleanCellValue());
				   
			   case FORMULA:
				   System.out.println(cell.getCellFormula());
				   break;
				default:
					return new SheetCells(CellType.BLANK, "");
				   
			   }   
		     }
	       } 
	        i++; 
	     }
	   file.close();
	   workbook.close();
	
		}catch(Exception e) {e.printStackTrace(); }
		return new SheetCells(CellType.BLANK, "");

	}
	
public static SheetCells parseUserInput(String input){
		
		if (input == null || input.trim().isEmpty()) {
			return new SheetCells(CellType.BLANK, "");
				}
		String trimmed = input.trim();		
			
	    if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
           return new SheetCells(CellType.BOOLEAN, Boolean.parseBoolean(input));
	    
	    } 
	    
	     try {
		   	   
			   double numeric= Double.parseDouble(input);
			   return new SheetCells(CellType.NUMERIC, numeric);
	   
		   
	    }catch(NumberFormatException e) {
		  System.out.println("STRING " + input+ " PARSED");
		   
		
	      }
	    return new SheetCells(CellType.STRING, trimmed);
	   } 
     public  void saveWorkbook(List<ObservableList<SheetCells>> dataTable , String path) throws IOException{
	          System.out.println(teste.getSheet());       
    	     
    	      String sheetnow= teste.getSheet();
    	      File file = new File(path);
    	      FileInputStream fileinp = new FileInputStream(file);
	          Workbook workbook = WorkbookFactory.create(fileinp);
	          Sheet sheet =workbook.getSheet(sheetnow);
             if(sheet == null ) {
            	 
            	 sheet = workbook.createSheet(sheetnow);
             }
	          int i =0;
	    while(i < dataTable.size()) {
	    	
	    	Row row = sheet.createRow(i);
	    	ObservableList<SheetCells> rowData = dataTable.get(i);
	    	int j = 0; 
	        while ( j < rowData.size()) {
		    	SheetCells cell = rowData.get(j);
		    	Cell apachecell = row.createCell(j, cell.getType());
		    	   
		    	
		    	switch (cell.getType()){
		    	
		    	case STRING:
		    		System.out.println("STRING");
		    		apachecell.setCellValue(String.valueOf(cell.getValue()));
		    		break;
		    	case NUMERIC:
		    		Object number= cell.getValue();
		    		if (number instanceof Number) {
		    		apachecell.setCellValue(((Number) number).doubleValue());
		    		System.out.println("string " + cell.getType()  + (cell.getValue() != null ?  cell.getValue().getClass() : "valor nulo"));
		    		   
		    		}else {
		    			apachecell.setCellValue(((Number) number).doubleValue());
		    			System.out.println("string " + cell.getType()  + (cell.getValue() != null ?  cell.getValue().getClass() : "valor nulo"));		    		}	
		    		break;
		    	case BOOLEAN:
		    		Object Booleanval = cell.getValue();
		    		if (Booleanval instanceof Boolean){
		    			System.out.println("string " + cell.getType()  + (cell.getValue() != null ?  cell.getValue().getClass() : "valor nulo"));
		    			apachecell.setCellValue((Boolean) Booleanval);
		    		}else {
		    			apachecell.setCellValue(false);
		    		}
		    	    break;
		    	case FORMULA:
		    		apachecell.setCellValue(String.valueOf( cell.getValue()));
		    		System.out.println("string " + cell.getType()  + (cell.getValue() != null ?  cell.getValue().getClass() : "valor nulo"));
		    		break;
		    	default:
		    	   apachecell.setBlank();
		    	   break;
		    		
		    	}
		    j++;
		   }		
	    i++;
	    }
	    
	   try(FileOutputStream newWorkbook = new FileOutputStream(file)){
		   
		   workbook.write(newWorkbook);
		   
	   }catch(Exception e ) {
		   System.out.println("ERROR IN SAVEWORKBOOK METH0D");
		   e.printStackTrace();}
	   workbook.close();
       } 
    
}


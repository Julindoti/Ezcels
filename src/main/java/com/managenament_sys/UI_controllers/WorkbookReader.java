package com.managenament_sys.UI_controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.managenament_sys.modules.SheetCells;
import com.managenament_sys.service.FileHolder;
import com.managenament_sys.service.WorkbookService;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

@Service
public class WorkbookReader {
    
	@Autowired
	private FileHolder holder;
	public static String sheetname;
	
    private static TableColumn<ObservableList<SheetCells>, String> columns;
    public  void setColumn(TableColumn<ObservableList<SheetCells>, String> columns) {
    	this.columns =  columns;
    }
    public TableColumn<ObservableList<SheetCells>, String> getColumn(){
    	return this.columns;
    }
	
	public  Map<String , List<List<SheetCells>>> readCellsGrid(String path) throws IOException{
	
		Map<String, List<List<SheetCells>>> MapSheets =  new LinkedHashMap<>();
		
     	try {
     	   File file2 = new File(path);
     	   holder.setCurrentFile(file2);
     	   FileInputStream file = new FileInputStream(file2);
    	   XSSFWorkbook workbook = new XSSFWorkbook(file);
    	   int numSheets = workbook.getNumberOfSheets();
    	
    	   
    	   for(int i= 0; i < numSheets; i++) {
           System.out.println("<-------------------------------------->");

           List<List<SheetCells>> table = new ArrayList<>();
    	   XSSFSheet sheet = workbook.getSheetAt(i);
    	   String sheetName = workbook.getSheetName(i);
    	   System.out.println("SHEET NAME:" + " " + sheetName);
    	  
  		  System.out.println("/--------------------------------------/");

    	   for (Row row : sheet){
    		   
    		   List<SheetCells> rowData = new ArrayList<>();
    		   for(Cell cell : row) {
    			   rowData.add(conversor(cell)); 
    			   System.out.println();
    			  
    		   }
    		   table.add(rowData);
    	   }
    	   
    	   MapSheets.put(sheetName, table);
  		 System.out.println("<-------------------------------------->");
  		 
    	  }  
    	   workbook.close();
     	}catch (Exception e) {e.printStackTrace();}
     	
		return MapSheets;
	}
	private static SheetCells conversor(Cell cell) {
		switch(cell.getCellType()) {
		
		   case NUMERIC:
			   System.out.println(cell.getNumericCellValue());
			   System.out.println("numero");
			   return new SheetCells(CellType.NUMERIC, cell.getNumericCellValue());
		   case STRING:
			   System.out.println( cell.getStringCellValue());
			   System.out.println("string");
			   return new SheetCells(CellType.STRING, cell.getStringCellValue());
		
		   case BOOLEAN:
			   System.out.println("Boolean");
			   System.out.println(cell.getBooleanCellValue());
			   return new SheetCells(CellType.BOOLEAN, cell.getBooleanCellValue());
		   case FORMULA:
			   System.out.println("Formula");
			   System.out.println(cell.getStringCellValue());
			   return new SheetCells(CellType.FORMULA, cell.getCellFormula());
			default:
				System.err.println("TUDO EM BRANCO CARA");
				return new SheetCells(CellType.BLANK, "");
			   
		   } 
		}
	public  static void builder(TableView<ObservableList<SheetCells>> tableView, 
			                   List<List<SheetCells>> rawData ) throws Exception{
		
		tableView.getItems().clear();
		tableView.getColumns().clear();	
		
		int maxcol = rawData.stream().mapToInt(List::size).max().orElse(0);
	    int columnsprefix = 20;
	    columnsprefix += maxcol;
		
		for(int i = 0;i < columnsprefix; i++) {
			
			final int colindex = i;
			
			TableColumn<ObservableList<SheetCells>, String> col= new TableColumn<>("A" + (i+ 1));
			col.setCellValueFactory(data -> {
				ObservableList<SheetCells> row = data.getValue(); 
				int rowindex= row.size();
				int morerows = rowindex + 30;
				   SheetCells cell = (row != null && row.size() > colindex)? row.get(colindex) : null;
				return new ReadOnlyStringWrapper(cell != null ? cell.displayValue() : "");
			});
			col.setEditable(true);
			col.setOnEditCommit(event ->{
				ObservableList<SheetCells> row = event.getRowValue();
				String newValue = event.getNewValue();
				SheetCells newCell = WorkbookService.parseUserInput(newValue);
				if(colindex >= row.size()){
					while(row.size() < colindex ) {	
						row.add(new SheetCells(CellType.BLANK, ""));
					}	
					row.add(newCell);
				}else {
				
					String oldValue = event.getOldValue();
				
	                row.set(colindex, newCell);
				}
			    });
			col.setCellFactory(tc -> new TableCell<ObservableList<SheetCells>, String>(){
				
				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					if(empty || getTableRow() == null || getTableRow().getItem() == null) {
						setText(null);
						setStyle("");
						setAlignment(Pos.CENTER_LEFT);	
					}else {
						ObservableList<SheetCells> row = getTableRow().getItem();
						if(row.size() > colindex) {
							SheetCells cell = row.get(colindex);
							if(cell != null && cell.getType() == CellType.NUMERIC ){
							}else {
								setAlignment(Pos.CENTER_LEFT);
							}
							setText(item);
						}
						
					}	
				}		
			});
			tableView.getColumns().add(col);
			col.setCellFactory(TextFieldTableCell.forTableColumn());
		
//			ObservableList<TableColumn<ObservableList<SheetCells>, ?>> initialPosition = FXCollections.observableArrayList(tableView.getColumns());
//			tableView.getColumns().addListener(new ListChangeListener<TableColumn<ObservableList<SheetCells>, ?>>() {
//				private boolean col_selected = false;
//				
//				@Override
//				public void onChanged(Change change) {
//					change.next();
//					if(change.wasReplaced() && !col_selected){
//						this.col_selected = true;
//						tableView.getColumns().setAll(initialPosition);
//						this.col_selected = false;
//						
//					}
//				}
//			});
		}
		
		ObservableList<ObservableList<SheetCells>> fxupdate = FXCollections.observableArrayList();
		for (List<SheetCells> row : rawData) {
			
			fxupdate.add(FXCollections.observableArrayList(row));	
		}
		tableView.setItems(fxupdate);
		tableView.setEditable(true);
		
	   }
	
	 public void createNewSheet(File file, String sheetName) throws IOException {
		 try {
			 
			 FileInputStream file2= new FileInputStream(file); 
			 XSSFWorkbook workbook = new XSSFWorkbook(file2);
			 
			 if(workbook.getSheet(sheetName) != null) {
				 System.out.println("Uma planilha de mesmo nome já existe");
				 workbook.close();
				 return;
			 }
			 
			 Sheet newSheet = workbook.createSheet(sheetName);			 
			 Row  headerRow = newSheet.createRow(0);
			 Cell headerCell = headerRow.createCell(10);
				 
		     try {
		    	 FileOutputStream saved =  new FileOutputStream(file);
		    	 workbook.write(saved);
		     }catch(Exception e) {e.printStackTrace();}
			 
			  workbook.close();
		 }catch(IOException e ) {e.printStackTrace();}	 
	 }
	
	 private final List<List<SheetCells>> data= FXCollections.observableArrayList();
	 public List<List<SheetCells>> getData(){
		    return data;
		 
	 }
	public static String getSheetName(){
		
		return sheetname;
		
	}
}

	
	
	
	





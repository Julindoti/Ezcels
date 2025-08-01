//package com.managenament_sys.service;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Service;
//
//import com.managenament_sys.dto.MonthlyDataDTO;
//import com.managenament_sys.modules.SheetCells;
//
//@Service
//public class ChartsService {
//
//	
//		private static class RawData {
//		private  LocalDate date;
//		private int quantity;
//		
//		
//	public RawData (LocalDate date, int quantity) {
//		
//		this.date = date;
//		this.quantity =  quantity;
//		
//	}
//	public LocalDate getDate() {return date;}
//	
//	
//	public List<MonthlyDataDTO> ChartsProcess (String path) throws IOException {
//		 List<MonthlyDataDTO> list= new ArrayList<>();
//		List<RawData> data = new ArrayList<>();		
//		try {
//			FileInputStream file = new FileInputStream(new File(path));
//			XSSFWorkbook workbook =  new XSSFWorkbook(file);
//		    Sheet sheet = workbook.getSheetAt(0);
//			
//		    
//		    StreamSupport.stream(sheet.spliterator(), false)
//		     .skip(1)
//		     .forEach(row ->{
//		    	 Cell dateCell= row.getCell(0);
//		    	 Cell quantityCell = row.getCell(1);
//		    	 
//		    	 if(dateCell != null && quantityCell != null 
//		    			 && dateCell.getCellType() == CellType.NUMERIC 
//		    			 && DateUtil.isCellDateFormatted(dateCell)
//		    			 && quantityCell.getCellType() == CellType.NUMERIC )
//		    	   {
//		    		 LocalDate date = dateCell.getLocalDateTimeCellValue().toLocalDate();
//		    		 int quantity = (int) quantityCell.getNumericCellValue();
//		    		 
//		    		 data.add(new RawData(date, quantity));
//		    	 }	 
//		     });
//		    return list.add("", null);
//		}catch(Exception e) {e.printStackTrace();}
////
////		Map<Month, Integer> monthlyResumes = data.stream()
////				.collect(Collectors.groupingBy(
////						dataResource -> dataResource.getDate().getMonth()),
////						Collectors.summingInt(dataResource -> dataResource.getQuantity()));
//	}	
//	
//   }
//}
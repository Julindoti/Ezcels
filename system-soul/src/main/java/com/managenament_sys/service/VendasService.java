package com.managenament_sys.service;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import com.managenament_sys.Vendas;
import java.util.List;

public class VendasService {
	
	public static void write(Sheet sheet, List <Vendas> vendas) {
		int line = 0;
		
		Row Title = sheet.createRow(line++);
		Title.createCell(0).setCellValue("Nome");
		Title.createCell(1).setCellValue("Valor");
		Title.createCell(2).setCellValue("Quantidade");
		
        
		for (Vendas v : vendas) {
			
			Row row = sheet.createRow(line++);
			row.createCell(0).setCellValue(v.getName());
			row.createCell(1).setCellValue(v.getValue());
			row.createCell(2).setCellValue(v.getQuantity());

			
		}	
	} 
}

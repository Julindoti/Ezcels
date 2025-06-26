package com.managenament_sys.service;
import 	java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.managenament_sys.modules.Gastos;

public class GastosService {
	
	private String Name;
	public static void write( Sheet sheet, List<Gastos> gastos ) {
		int line=0;
		
		Row Title = sheet.createRow(line++);
		Title.createCell(0).setCellValue("Nome");
		Title.createCell(1).setCellValue("Valor");
		Title.createCell(2).setCellValue("Peso(kg)");
		
		
		for (Gastos g : gastos) {
			
			Row row = sheet.createRow(line++);
			row.createCell(0).setCellValue(g.getName());
			row.createCell(1).setCellValue(g.getValue());
			row.createCell(2).setCellValue(g.getWeight());
			
		}
	}

	
	public String getNameGastos() {
		
		return this.Name;
	}
	public void setNameGastos(String Name) {
		
		this.Name = Name;
		
	}

}

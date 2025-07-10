package com.managenament_sys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.managenament_sys.modules.Produto;
 
public class ProdutoService {
	
	public static void write(Sheet sheet, List<Produto>  produtos) {
		int line = 0;
		
		Row Title = sheet.createRow(line++);
		Title.setHeightInPoints(50f);
		Title.createCell(0).setCellValue("Nome");
		Title.createCell(1).setCellValue("Preço");
		Title.createCell(2).setCellValue("Peso(g)");
		Title.createCell(3).setCellValue("Quantidade");
		
		for (Produto p : produtos) {
			Row row= sheet.createRow(line++);
			row.createCell(0).setCellValue(p.getName());
			row.createCell(1).setCellValue(p.getPrice());
			row.createCell(2).setCellValue(p.getWeight());
			row.createCell(3).setCellValue(p.getQuantity());
		}
		
	}
	public List<Produto> read(Sheet sheet){
		
		
		List<Produto> produtos= new ArrayList<>();
		
		for (int i= 1; i<=sheet.getLastRowNum(); i++) {
		
			Row row= sheet.getRow(i);
			if (row == null) continue;
			System.out.println(row);
			System.out.println(sheet.getPhysicalNumberOfRows());
			System.out.println((String)row.getCell(0).getStringCellValue());
			Produto p = new Produto();
			
			System.out.println((String)row.getCell(0).getStringCellValue());
			System.out.println((float)row.getCell(1).getNumericCellValue());
			System.out.println((int) row.getCell(2).getNumericCellValue());
			System.out.println((int) row.getCell(3).getNumericCellValue());    
			produtos.add(p);
			
		}
		
		return produtos;
		
	}
}

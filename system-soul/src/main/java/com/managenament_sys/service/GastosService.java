package com.managenament_sys.service;
import 	org.apache.poi.ss.usermodel.*;

import java.sql.*;
import java.util.List;
import com.managenament_sys.Gastos;

public class GastosService {
	
	
	private String Name;
	private static String jdbc= "jbdc:postgresql://localhost:5433/ezcels";
	private static String user="root";
	private static String pwd="1234567";
	
	private static String command= "SELECT id, date, name , quantity, value, weight FROM gastos";
	
	public static void write( Sheet sheet, List<Gastos> gastos ) {
		try(
			Connection conn= DriverManager.getConnection(jdbc, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.	executeQuery(command);
			){
			
		int line=0;
		
		Row Title = sheet.createRow(line++);
		Title.createCell(0).setCellValue("Nome");
		Title.createCell(1).setCellValue("Valor");
		Title.createCell(2).setCellValue("Peso(kg)");
		Title.createCell(3).setCellValue("Quantidade");
		
		
		//for (Gastos g : gastos) 
		while (rs.next()){
			
			Row row = sheet.createRow(line++);
			row.createCell(0).setCellValue(rs.getInt("id"));
			row.createCell(1).setCellValue(rs.getDate("date"));
			row.createCell(2).setCellValue(rs.getString("name"));
			row.createCell(3).setCellValue(rs.getInt("quantity"));
			row.createCell(4).setCellValue(rs.getFloat("weight"));
			
			}
		}catch(Exception e){e.printStackTrace();}
	}
	public String getNameGastos() {
		
		return this.Name;
	}
	public void setNameGastos(String Name) {
		
		this.Name = Name;
		
	}

}

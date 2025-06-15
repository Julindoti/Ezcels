package com.managenament_sys.controllers;

import com.managenament_sys.service.*;
import com.managenament_sys.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.managenament_sys.Produto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class geralManagersheet {
	
	private final GastosService gastosService; 
	private final VendasService vendasService;
	private final ProdutoService produtoService;
	private final String xlsxpath;
	private List<Produto> produtos ;
	
	public geralManagersheet(String xlsxpath) {
		
		this.xlsxpath = xlsxpath;
		this.gastosService= new GastosService();
		this.vendasService= new VendasService();
		this.produtoService= new ProdutoService();
		
	}
	
	public void saveSpreadsheet(List<Produto> produtos, List<Gastos> gastos, List<Vendas> vendas) {
		
		UsuarioService u = new UsuarioService();
		
		Logincontroller verify = new Logincontroller();
		//List <Usuario>users = Usuario.users;
		//verify.setUser(users);
		//u.UpUser(users);
		
		if (verify.pass == true) {
			try(Workbook workbook= new XSSFWorkbook()){
				
				Sheet pageProducts= workbook.createSheet("Produtos");
				Sheet pageExpenses= workbook.createSheet("Gastos");
				Sheet pageSeels= workbook.createSheet("Vendas");
				
				ProdutoService.write(pageProducts, produtos);
				VendasService.write(pageSeels, vendas);
				GastosService.write(pageExpenses, gastos);
				padronizacao(pageProducts);
				
				try (FileOutputStream out = new FileOutputStream(xlsxpath)){
					workbook.write(out);
					System.out.println("Arquivo sendo salvo em..." + xlsxpath);
					
				}	
			}catch (Exception e) {e.printStackTrace();}
			
		   }else{
			   System.out.println("permission denied");
			   }
		   }
	public void padronizacao(Sheet sheet){
		
		SheetConditionalFormatting sheetP= sheet.getSheetConditionalFormatting();
		
		ConditionalFormattingRule rule1= sheetP.createConditionalFormattingRule("MOD(ROW(),2)");
		PatternFormatting fill1= rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		
		CellRangeAddress[] cellrange= {
			CellRangeAddress.valueOf("A1:Z100")					
		};
		sheetP.addConditionalFormatting(cellrange, rule1);
		
	}
	public void readSpreadsheet() {
	   Logincontroller verify = new Logincontroller();
	   //List <Usuario> users= Usuario.users;
	   //verify.setUser(users);
	   
		if(verify.pass == true) {	
			//System.out.println("Lenndo arquivo" + users.get(0) +"!");
		    try(FileInputStream fis = new FileInputStream(xlsxpath)){
				Workbook workbook = new XSSFWorkbook(fis); 
				Sheet ProductsSheet= workbook.getSheet("Produtos");
				this.produtos = produtoService.read(ProductsSheet);
				
				System.out.println("ARMAZEM DE COLETA POR LOTES:"+ produtos.size());

	       }catch (IOException e){e.printStackTrace();}
		    
		  
	    }else {
		System.out.println("permission denied ");}
	    }
	public List<Produto> getProdutos(){return produtos;}
	    
	
   	}



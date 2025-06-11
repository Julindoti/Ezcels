package com.managenament_sys;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.managenament_sys.controllers.Logincontroller;
import com.managenament_sys.controllers.geralManagersheet;
import com.managenament_sys.service.DatabaseService;

public class Main {
	public static void main(String[] args) {
		try {
			// Initialize database
			DatabaseService.initialize();
			
			// Create initial users
			Usuario nicole = new Usuario("Nicole", "NICOLE123@GMAIL.COM", "NI123", Levels.USER);
			Usuario fabiana = new Usuario("Fabiana", "FA2016@GMAIL.COM", "FABIANA876", Levels.ADMIN);
			Usuario gabi = new Usuario("GABI", "GABI190@GMAIL.COM", "FABIANA876", Levels.ADMIN);
			
			DatabaseService.saveUsuario(nicole);
			DatabaseService.saveUsuario(fabiana);
			DatabaseService.saveUsuario(gabi);
			
			// Create initial products
			Produto ovo1 = new Produto("OVO-1A", 30, 70, 900, new Date());
			Produto ovo2 = new Produto("OVO-2A", 60, 80, 300, new Date());
			
			DatabaseService.saveProduto(ovo1);
			DatabaseService.saveProduto(ovo2);
			
			// Create initial expenses
			Gastos gasto1 = new Gastos("LOTE-1A", 17.00, new Date(), 1000);
			DatabaseService.saveGasto(gasto1);
			
			// Create initial sales
			Vendas venda1 = new Vendas("SEGUNDA-FEIRA", 700.00, 500, new Date());
			DatabaseService.saveVenda(venda1);
			
			// Get data for spreadsheet
			String xlsxpath = "/home/julio/eclipse-workspace/system-soul/planilha_OvosSantaLuzia3.xlsx";
			List<Gastos> gastos = DatabaseService.getAllGastos();
			List<Vendas> vendas = DatabaseService.getAllVendas();
			List<Produto> produtos = DatabaseService.getAllProdutos();
			
			// Save to spreadsheet
			geralManagersheet manager = new geralManagersheet(xlsxpath);
			manager.saveSpreadsheet(produtos, gastos, vendas);
			manager.readSpreadsheet();
			
			// Test user login
			System.out.println("Total users: " + DatabaseService.getAllUsuarios().size());
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter email to test login:");
			String email = scanner.nextLine();
			
			try {
				Usuario user = DatabaseService.findUsuarioByEmail(email);
				System.out.println("Login successful for user: " + user.getUsername());
			} catch (Exception e) {
				System.out.println("Login failed: User not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseService.close();
		}
	}
}




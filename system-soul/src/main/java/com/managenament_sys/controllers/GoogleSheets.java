//package com.managenament_sys.controllers;
//
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.List;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.services.sheets.v4.Sheets;
//import com.google.api.services.sheets.v4.SheetsScopes;
//import com.google.api.services.sheets.v4.model.ValueRange;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.api.services.sheets.v4.model.*;
//import java.util.ArrayList;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.http.HttpRequestInitializer;
//import com.google.auth.http.HttpCredentialsAdapter;
//
//public class GoogleSheets {
//	
//	public class GoogleSheetsConn{
//		
//		private  static final String APP_NAME="Ezcels";
//		private static final JsonFactory JSON_FAC = JacksonFactory.getDefaultInstance();
//		private static final String SPREADSHEET_ID="1pzqXr6bIsiZmVLI2F9pAhfSW8uecEjFXZX_rcLoCHKM";
//		
//		
//		public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
//	 		
//			GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("creds.json")).createScoped(List.of(SheetsScopes.SPREADSHEETS));
//			
//		HttpRequestInitializer requestInitializer= new HttpCredentialsAdapter(credentials);
//		
//		return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FAC, requestInitializer)
//				.setApplicationName(APP_NAME)
//				.build();			
//		}
//		public static List<List<Object>> readTas(String tab) throws Exception{
//			
//			Sheets sheetsService= getSheetsService();
//			ValueRange response = sheetsService.spreadsheets().values()
//					.get(SPREADSHEET_ID, tab + "|A1:E")
//					.execute();
//			return response.getValues();			
//		}
//		
//		public static void appendRow(String tab, List<Object> rowData) throws Exception {
//			Sheets sheetsService = getSheetsService();
//			ValueRange appendBody = new ValueRange().setValues(List.of(rowData));
//			sheetsService.spreadsheets().values()
//				.append(SPREADSHEET_ID, tab + "!A1", appendBody)
//				.setValueInputOption("RAW")
//				.execute();
//		}
//
//		public static void updateRow(String tab, int rowIndex, List<Object> rowData) throws Exception {
//			Sheets sheetsService = getSheetsService();
//			String range = tab + "!A" + (rowIndex + 1); // rowIndex is 0-based
//			ValueRange body = new ValueRange().setValues(List.of(rowData));
//			sheetsService.spreadsheets().values()
//				.update(SPREADSHEET_ID, range, body)
//				.setValueInputOption("RAW")
//				.execute();
//		}
//
//		public static void deleteRow(String tab, int rowIndex) throws Exception {
//			Sheets sheetsService = getSheetsService();
//			List<Request> requests = List.of(
//				new Request().setDeleteDimension(
//					new DeleteDimensionRequest()
//						.setRange(new DimensionRange()
//							.setSheetId(getSheetIdByName(sheetsService, tab))
//							.setDimension("ROWS")
//							.setStartIndex(rowIndex)
//							.setEndIndex(rowIndex + 1)
//						)
//					)
//				);
//			BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
//			sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID, body).execute();
//		}
//
//		// Helper to get the sheet ID by name
//		private static int getSheetIdByName(Sheets sheetsService, String sheetName) throws Exception {
//			Sheets.Spreadsheets.Get request = sheetsService.spreadsheets().get(SPREADSHEET_ID);
//			Spreadsheet spreadsheet = request.execute();
//			for (Sheet sheet : spreadsheet.getSheets()) {
//				if (sheet.getProperties().getTitle().equals(sheetName)) {
//					return sheet.getProperties().getSheetId();
//				}
//			}
//			throw new IllegalArgumentException("Sheet not found: " + sheetName);
//		}
//	}
//}

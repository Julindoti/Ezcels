package com.managenament_sys.UI_controllers;



import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.managenament_sys.modules.SheetCells;
import com.managenament_sys.service.FileHolder;
import com.managenament_sys.service.FilePickerService;
import com.managenament_sys.service.NavigationService;
import com.managenament_sys.service.Sheetindex;
import com.managenament_sys.service.WorkbookService;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;

@Component
@Scope("singleton")
public class MainPageController {

	@Value("classpath:/fxml/MainPage.fxml")
	Resource LoginResource;
	
	@Value("classpath:/fxml/modals/Chartsmodal.fxml")
	Resource ChartsResource;
	
	private List<List<SheetCells>> data = new ArrayList<>();
	
    public List<List<SheetCells>> getData(){return data;}
    
    public void setData (List<List<SheetCells>> data){this.data= data;} 
    
    public String DatatoString(){
        if(this.getData()!= null){
    		return this.getData().toString();
    	}else {return null;}
    }
    private Map< String, List<List<SheetCells>>> MapSheets = new LinkedHashMap<>() ;
    
    
    @Autowired
    private FileHolder holder;
    @Autowired 
    private WorkbookService service;
    @Autowired
    private Sheetindex namesheet;
    @Autowired
    private CreateSheetController createModal;
    @Autowired
    private NavigationService navigate;
	@Autowired
	private FilePickerService picker;
	@Autowired
	private WorkbookReader reader;
	@FXML
	private TextArea user_log;
	@FXML 
	private Button open_file_btn;
	@FXML 
	private Button save_btn;
	@FXML
	private TableColumn<?, ?> user_input_cell;
	@FXML
	private TabPane tab_pane;
	@FXML
	private Tab tab;
	@FXML
	private ScrollPane left_scroll;
	@FXML
	private VBox left_anchor_scroll;
	@FXML
	private Label datentime;
	@FXML
	private TableView<ObservableList<SheetCells>> sheetView;
    
	     @FXML 
	     void initialize() {
	    	 
	    	 tab_pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
	    	  
	         left_scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	         	 
	     } 
	     
	     @FXML 
	     public void LoadSheet(ActionEvent event) throws IOException {
	    	 
	    	 try {
		          String pather =  picker.PickerAct();
		          namesheet.setPath(pather);
		          System.out.println(WorkbookReader.getSheetName());
		             
		    	  this.MapSheets = (reader.readCellsGrid(pather)); 
		    	  int max = MapSheets.size();  
		    	  
		    	  String SheetName =MapSheets.keySet().iterator().next();
		    	  namesheet.setSheet(SheetName);
		    	  
		    	  System.out.println(namesheet.getSheet());
		    	  
		    	  this.data=MapSheets.get(SheetName);
		    	  WorkbookReader.builder(sheetView, this.getData());
		    	 
		    	  tab.setText(WorkbookReader.sheetname);
		    	  Set<String> values = MapSheets.keySet();
		    	  left_anchor_scroll.getChildren().clear();
		    	  for (String name : values)  {
		    		 
		    		  Button button = new Button();
		
		    		  button.setText(name);
		    		  button.setMaxHeight(40);
		    		  button.setMinHeight(40);
		    		  button.setMinWidth(116);
		    		  button.setMaxWidth(116);
		    		  button.setLayoutX(40);
		    		  button.setTranslateX(40);
		    		  
		    		  left_anchor_scroll.getChildren().add(button);
		  
		    		  button.addEventHandler(ActionEvent.ACTION, events ->{
		    			  
		    			  this.data=MapSheets.get(name);
		    			  namesheet.setSheet(name);
		    			  tab.setText(name);
				    	  try {
							WorkbookReader.builder(sheetView, this.getData());
						} catch (Exception e) {
	         							e.printStackTrace();
						}
				    	
		    		  });
		 
		    	  }
		    	  
		    	  open_file_btn.addEventHandler(ActionEvent.ACTION, events ->{
		    		  
		    		  user_log.setText("Arquivo " + picker.getFilename()+ " carregado com sucesso" );
		    	  });		  	 
		    }catch(Exception e ) {
					open_file_btn.addEventHandler(ActionEvent.ACTION, events ->{
				          user_log.setText("Falha ao carregar o arquivo. \n" +"Verifique se corresponde a um arquivo excel e tente novamente");
				          e.printStackTrace();	  
					});
		    }
		     finally {}
	     }
       @FXML
	   public void SaveSheet(ActionEvent event) {
		   
		   try {
			   
			   System.out.println("SAVING SHEET...");
			   service.saveWorkbook(sheetView.getItems(), namesheet.getPath());	 
			  System.out.println(this.getData());
			   save_btn.addEventHandler(ActionEvent.ACTION, events -> {
				   user_log.setText("Arquivo " + picker.getFilename() +  " salvo com sucesso!");
			   });	   
		   }catch(Exception e) {
			   save_btn.addEventHandler(ActionEvent.ACTION, events -> {
				   user_log.setText("Erro ao salvar o arquivo, tente novamente!");
				   System.err.println("ERROR WHEN SAVING SHEETS:");
				   e.printStackTrace();
			   });   
		   }
		   finally{}
	  
       }
      @FXML
      void handledeleteFile(){
    	  
    	  File sefoda =  holder.getCurrentFile(); 
    	  sefoda.delete();
      }
      @FXML
	  public void callCharts(ActionEvent e) {
		   try {
			  
			   navigate.navigate(ChartsResource);
			   
		   }catch(Exception err){err.printStackTrace();}    
	  }
      @FXML
      void handleAddSheet(ActionEvent event) throws IOException{
    	  
    	  createModal.handleInitEvent(event);	  
      }
      @FXML
      void back() {
    	  
    	  Platform.exit();
    	  
    	  
      }
      @FXML
      void handleRemoveSheet(ActionEvent event){
    	  
    		 Alert confirmPop = new Alert(Alert.AlertType.CONFIRMATION);
	    	 confirmPop.setTitle("Excluir Planilha ");
	    	 confirmPop.setHeaderText("Deseja mesmo excluir essa planilha?");
	    	 confirmPop.setContentText("Essa ação não terá mais volta");
	    	 Optional<ButtonType> confirmation =  confirmPop.showAndWait();	    	 
	    	 if(confirmation.isPresent() && confirmation.get() == ButtonType.OK){
	    		 System.out.println("teste");
	    		//logica 	
	    	 }else {
	    		   confirmPop.close();
	      	}
      }
    
}

package com.managenament_sys.modules;

import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

 
public class SheetCells {

	private final CellType type;
	private final ObjectProperty<Object> value;
	
	public SheetCells (CellType type,  Object value) {
		
		this.type = type;
		this.value = new SimpleObjectProperty<>(value);
    }
	

	public CellType getType(){
		
		return type;
	}
	public ObjectProperty<Object> valueProperty(){
		
		return 	value;
		
	}
	public Object getValue(){
		 
		return value.get();
	}
	public String displayValue() {
		if (value.get() != null){
			
			return value.get().toString();
			
		}
		return "";

	}
	public void setValue(Object value) {
		
		this.value.set(value);
			
	}

}

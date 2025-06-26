package com.managenament_sys.modules;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "gastos")
public class Gastos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double value;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(nullable = false)
	private int quantity;
	@Column(nullable= false)
	private float weight;
	
	public Gastos() {}
	
	public Gastos(String name, double value, Date date, int quantity, float weight) {
		setName(name);
		setValue(value);
		setDate(date);
		setQuantity(quantity);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getWeight(){
		return weight;
	}
	public void setWeight(float weight){
		this.weight= weight;
		
	}
}


package com.managenament_sys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vendas")
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double value;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Vendas() {}
	
	public Vendas(String name, double value, int quantity, Date date) {
		setName(name);
		setValue(value);
		setQuantity(quantity);
		setDate(date);
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
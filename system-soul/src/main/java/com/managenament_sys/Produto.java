package com.managenament_sys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private float price;
	
	@Column(nullable = false)
	private int weight;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Produto() {}
	
	public Produto(String name, float price, int weight, int quantity, Date date) {
		setName(name);
		setPrice(price);
		setDate(date);
		setWeight(weight);
		setQuantity(quantity);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}

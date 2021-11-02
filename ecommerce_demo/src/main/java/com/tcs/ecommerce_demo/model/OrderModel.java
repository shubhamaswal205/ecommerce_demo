package com.tcs.ecommerce_demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int product_id;
	
	public int getProduct_id() {
		return product_id;
	}
	

	public OrderModel() {
		
	}



	public OrderModel(int product_id, String name, int price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Column
	private String name;
   
	@Column
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
  
}

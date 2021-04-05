package com.prueba.accenture.models;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6103196290084354434L;

	@Size(min = 2, max = 25)
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private Double price;
	
	
	@NotNull
	@NotBlank
	private Integer amount;
	
	
	public Product() {
		super();
	}

	public Product(String name, Double price, Integer amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}

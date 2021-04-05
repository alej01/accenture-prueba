package com.prueba.accenture.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String idOrder;
	
	@NotNull
	@NotBlank
	private String identificationConsumer;
	
	
	private String addressConsumer;
	
	private Date date;
	
	@NotNull
	private List<Product> products;

	public String getIdentificationConsumer() {
		return identificationConsumer;
	}

	public void setIdentificationConsumer(String identificationConsumer) {
		this.identificationConsumer = identificationConsumer;
	}

	public String getAddressConsumer() {
		return addressConsumer;
	}

	public void setAddressConsumer(String addressConsumer) {
		this.addressConsumer = addressConsumer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Order(String idOrder, String identificationConsumer, String addressConsumer, List<Product> products, Date date) {
		super();
		this.idOrder = idOrder;
		this.identificationConsumer = identificationConsumer;
		this.addressConsumer = addressConsumer;
		this.products = products;
		this.date = date;
	}

	public Order() {
		super();
	}
	
	
	

}

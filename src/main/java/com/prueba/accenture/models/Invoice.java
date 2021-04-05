package com.prueba.accenture.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1961252112153131480L;
	
	
	@NotNull
	@NotBlank
	private String noInvoice;
	
	@NotNull
	@NotBlank
	private String identificationCustomer;
	
	@NotNull
	@NotBlank
	private String address;
	
	@NotNull
	@NotBlank
	private Date date;
	
	@NotNull
	private List<Product> products;
	
	@NotNull
	@NotBlank
	private Double subTotal;
	
	@NotNull
	@NotBlank
	private Double sendingCost;
	
	@NotNull
	@NotBlank
	private Double iva;
	
	@NotNull
	@NotBlank
	private Double total;

	public String getNoInvoice() {
		return noInvoice;
	}

	public void setNoInvoice(String noInvoice) {
		this.noInvoice = noInvoice;
	}

	public String getIdentificationCustomer() {
		return identificationCustomer;
	}

	public void setIdentificationCustomer(String identificationCustomer) {
		this.identificationCustomer = identificationCustomer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getSendingCost() {
		return sendingCost;
	}

	public void setSendingCost(Double sendingCost) {
		this.sendingCost = sendingCost;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Invoice(String noInvoice, String identificationCustomer, String address, List<Product> products,
			Double subTotal, Double sendingCost, Double iva, Double total, Date date) {
		super();
		this.noInvoice = noInvoice;
		this.identificationCustomer = identificationCustomer;
		this.address = address;
		this.products = products;
		this.subTotal = subTotal;
		this.sendingCost = sendingCost;
		this.iva = iva;
		this.total = total;
		this.date = date;
	}

	public Invoice() {
		super();
	}
	
	

}

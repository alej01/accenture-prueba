package com.prueba.accenture.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prueba.accenture.models.Invoice;
import com.prueba.accenture.models.Order;

@Repository
public class RepositoryOrdersAndInvoices {
	
	private List<Order> orders;
	
	private List<Invoice> invoices;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public RepositoryOrdersAndInvoices() {
		orders = new ArrayList<Order>();
		invoices = new ArrayList<Invoice>();
	}
	
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public Invoice getInvoiceByNoInvoice (String id) {
		Invoice invoice = null;
		for (Invoice inv : invoices) {
			if (id.equals(inv.getNoInvoice())) {
				invoice = inv;
			}
		}
		return invoice;
	}

	public Order getOrderByIdOrder (String id) {
		Order order = null;
		for (Order or : orders) {
			if (id.equals(or.getIdOrder())) {
				order = or;
			}
		}
		return order;
	}
	
	public void deleteInvoiceAndOrder(String id) {
		Order order = getOrderByIdOrder(id);
		Invoice invoice = getInvoiceByNoInvoice(id);
		
		if (order != null && invoice != null) {
			orders.remove(order);
			invoices.remove(invoice);
		}
	}
}

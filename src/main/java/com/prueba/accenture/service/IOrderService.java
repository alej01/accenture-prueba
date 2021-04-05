package com.prueba.accenture.service;

import java.util.List;

import com.prueba.accenture.models.Invoice;
import com.prueba.accenture.models.Order;
import com.prueba.accenture.models.Product;

public interface IOrderService {
	
	public Invoice newOrder(Order order);
	
	public Invoice editOrder(String order, List<Product> newProducts) throws Exception;
	
	public Invoice deleteOrder(String idOrder) throws Exception;
	
	public List<Order> getOrders();

}

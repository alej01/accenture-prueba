package com.prueba.accenture.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.accenture.models.Invoice;
import com.prueba.accenture.models.Order;
import com.prueba.accenture.models.Product;
import com.prueba.accenture.repository.RepositoryOrdersAndInvoices;
import com.prueba.accenture.utils.Utils;

@Service
public class OrderService implements com.prueba.accenture.service.IOrderService {
	
	@Resource
	private RepositoryOrdersAndInvoices repo;

	@Override
	public Invoice newOrder(Order order) {
		order.setDate(new Date());
		order.setIdOrder(Utils.randomString());
		
		Invoice invoice = new Invoice();
		
		invoice.setIdentificationCustomer(order.getIdentificationConsumer());
		invoice.setAddress(order.getAddressConsumer());
		invoice.setNoInvoice(order.getIdOrder());
		invoice.setProducts(order.getProducts());
		
		Double totalProducts = 0D;
		
		for (Product pr : order.getProducts()) {
			totalProducts += pr.getPrice();
		}
		
		invoice.setSubTotal(totalProducts);
		if (totalProducts > 70000D) {
			invoice.setIva((totalProducts * 0.19));
			if (totalProducts > 100000D) {
				invoice.setSendingCost(0D);
			}else {
				invoice.setSendingCost(10000D);
			}
		} else {
			invoice.setSendingCost(10000D);
			invoice.setIva(0D);
		}
		invoice.setDate(new Date());
		invoice.setTotal(totalProducts + invoice.getIva() + invoice.getSendingCost());
		
		repo.addInvoice(invoice);
		repo.addOrder(order);
		
		return invoice;
	}

	@Override
	public Invoice editOrder(String orderid, List<Product> newProducts) throws Exception {
		Order order = repo.getOrderByIdOrder(orderid);
		Invoice invoice = repo.getInvoiceByNoInvoice(orderid);
		if (order != null) {
			if (Utils.getDifferenceBetwenDates(order.getDate(), new Date()) <= 5) {
				Double costNewProducts = 0D;
				Double costExistProduct = 0D;
				for (Product product : order.getProducts()) {
					costExistProduct += product.getPrice();
				}
				for (Product product : newProducts) {
					costNewProducts += product.getPrice();
				}
				if (costNewProducts >= costExistProduct) {
					if (invoice != null) {
						invoice.setProducts(newProducts);
					}
					if (costNewProducts >= 100000) {
						invoice.setSendingCost(0D);
					}
					invoice.setTotal(costNewProducts + invoice.getIva() + invoice.getSendingCost());
					invoice.setSubTotal(costNewProducts);
					order.setProducts(newProducts);
					invoice.setProducts(newProducts);
					repo.deleteInvoiceAndOrder(orderid);
					repo.addInvoice(invoice);
					repo.addOrder(order);
				}else {
					throw new Exception("Los nuevos productos cuestan menos que los anteriores, no se puede editar");
				}
				
			} else {
				throw new Exception("El pedido se realizo hace mas de 5 hoas, no se puede editar");
			}
		} else {
			throw new Exception("No existe la orden con el id " + orderid);
		}
		return invoice;
		
	}

	@Override
	public Invoice deleteOrder(String idOrder) throws Exception {
		Order order = repo.getOrderByIdOrder(idOrder);
		if (order != null) {
			if (Utils.getDifferenceBetwenDates(order.getDate(), new Date()) > 12) {
				Invoice cancelInvoice = new Invoice();
				
				Double costExistProduct = 0D;
				for (Product product : order.getProducts()) {
					costExistProduct += product.getPrice();
				}
				cancelInvoice.setNoInvoice(Utils.randomString());
				cancelInvoice.setDate(new Date());
				cancelInvoice.setIdentificationCustomer(order.getIdentificationConsumer());
				cancelInvoice.setIva(0D);
				cancelInvoice.setSendingCost(0D);
				cancelInvoice.setSubTotal(costExistProduct * 0.10);
				cancelInvoice.setTotal(costExistProduct * 0.10);
				repo.deleteInvoiceAndOrder(idOrder);
				return cancelInvoice; 
			}else {
				repo.deleteInvoiceAndOrder(idOrder);
				return null;
			}
		} else {
			throw new Exception("No existe la orden con el id " + idOrder);
		}
	}

	@Override
	public List<Order> getOrders() {
		return repo.getOrders();
	}

}

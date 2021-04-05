package com.prueba.accenture.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.accenture.models.Invoice;
import com.prueba.accenture.models.Order;
import com.prueba.accenture.models.Product;
import com.prueba.accenture.service.IOrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private IOrderService service;
	
	
	@PostMapping
	public ResponseEntity<?> addNewOrder(@Valid @RequestBody Order order) {
		try {
			Invoice invoice = service.newOrder(order);
			return new ResponseEntity<Invoice>(invoice, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/edit/{idOrder}")
	public ResponseEntity<?> editOrder (@PathVariable String idOrder,@Valid @RequestBody List<Product> newProducts){
		try {
			Invoice invoice = service.editOrder(idOrder, newProducts);
			return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{idOrder}")
	public ResponseEntity<?> deleteOrder(@PathVariable String idOrder){
		try {
			Invoice invoice = service.deleteOrder(idOrder);
			if (invoice != null) {
				return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Orden eliminada", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<?> getOrders(){
		try {
			return new ResponseEntity<List<Order>>(service.getOrders(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

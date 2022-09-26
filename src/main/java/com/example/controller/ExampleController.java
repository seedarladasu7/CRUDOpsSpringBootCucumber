package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.Order;
import com.example.model.Product;

@RestController
public class ExampleController {
	
	@RequestMapping("/getProducts")
	public List<Product> getProducts() {	
		System.out.println("getProducts called");
		return new ArrayList<>();		
	}
	
	public List<Order> getOrders() {
		System.out.println("getOrders called");
		return new ArrayList<>();
	}
	
	@RequestMapping("/")
	public List<Employee> getCustomers() {
		System.out.println("getCustomers called");
		return new ArrayList<>();
	}

}

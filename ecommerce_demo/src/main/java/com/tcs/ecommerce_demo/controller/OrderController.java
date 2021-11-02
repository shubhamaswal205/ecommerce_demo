package com.tcs.ecommerce_demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ecommerce_demo.model.OrderModel;
import com.tcs.ecommerce_demo.model.Product;
import com.tcs.ecommerce_demo.service.OrderService;
import com.tcs.ecommerce_demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	 
	@GetMapping("/order")
	private List<OrderModel> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping("/order/{id}")
	private OrderModel getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}
	
    @DeleteMapping("/order/{id}")
    private void deleteOrderById(@PathVariable("id") int id) {
    	orderService.delete(id);
	}
    
    @PostMapping("/order/{id}")
    private ResponseEntity<Integer> saveOrder(@PathVariable("id") int id ){
    	Product myproduct = productService.getProductById(id);
    	String name = myproduct.getName();
    	int price = myproduct.getPrice();
    	int product_id = myproduct.getId();
    	OrderModel myorder = new OrderModel(product_id,name,price);
    	orderService.saveOrUpdate(myorder);
    	return new ResponseEntity<Integer>(myorder.getId(),HttpStatus.OK);
    }
	
}

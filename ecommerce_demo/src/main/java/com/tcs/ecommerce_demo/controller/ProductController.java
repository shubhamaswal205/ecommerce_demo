package com.tcs.ecommerce_demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ecommerce_demo.model.Product;
import com.tcs.ecommerce_demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	 
	@GetMapping("/product")
	private List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	private Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
    @DeleteMapping("/product/{id}")
    private void deleteProductById(@PathVariable("id") int id) {
		 productService.delete(id);
	}
    
    @PostMapping("/product")
    private ResponseEntity<Integer> saveProduct(@RequestBody Product product){
    	productService.saveOrUpdate(product);
    	return new ResponseEntity<Integer>(product.getId(),HttpStatus.OK);
    }
	
}

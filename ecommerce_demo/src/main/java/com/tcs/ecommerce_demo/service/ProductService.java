package com.tcs.ecommerce_demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce_demo.model.Product;
import com.tcs.ecommerce_demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> productList = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> productList.add(product));
		return productList;
	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}
	
	public void saveOrUpdate(Product product) 
	{
		productRepository.save(product);
	}
	
	public void delete(int id) 
	{
		productRepository.deleteById(id);
	} 
}

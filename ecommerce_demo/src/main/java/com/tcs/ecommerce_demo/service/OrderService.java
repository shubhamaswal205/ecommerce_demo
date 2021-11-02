package com.tcs.ecommerce_demo.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce_demo.model.OrderModel;
import com.tcs.ecommerce_demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	public List<OrderModel> getAllOrders(){
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		orderRepository.findAll().forEach(order -> orderList.add(order));
		return orderList;
	}



	public OrderModel getOrderById(int id) {
		return orderRepository.findById(id).get();
	}
	
	public void saveOrUpdate(OrderModel order) 
	{
		orderRepository.save(order);
	}
	
	public void delete(int id) 
	{
		orderRepository.deleteById(id);
	} 
}

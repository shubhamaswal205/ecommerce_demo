package com.tcs.ecommerce_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ecommerce_demo.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

}

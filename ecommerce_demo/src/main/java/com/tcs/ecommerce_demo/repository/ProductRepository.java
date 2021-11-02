package com.tcs.ecommerce_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.ecommerce_demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

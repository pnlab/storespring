package com.example.learn.repository;

import com.example.learn.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

  Order findOneByUserId(Integer userId);
}
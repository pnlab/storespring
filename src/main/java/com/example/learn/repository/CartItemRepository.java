package com.example.learn.repository;

import java.util.Collection;

import com.example.learn.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
  Collection<CartItem> findByUserId(Integer userId);
  void deleteAllByUserId(Integer userId);
  
}
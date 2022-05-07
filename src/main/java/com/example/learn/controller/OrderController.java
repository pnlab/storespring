package com.example.learn.controller;

import com.example.learn.CustomUserDetails;
import com.example.learn.model.Order;
import com.example.learn.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService orderService;
  
  // lay 1 order cua 1 user
  @GetMapping("/")
  public Order getOrder() {
    CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return orderService.getOrder(u.getUserId());
  }
  // Lay ds cac order cua 1 user
  @GetMapping("/{id}")
  public Order getOrders(@PathVariable Integer id) {
    CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return orderService.getOrderById(u.getUserId(), id );
  }

  



  // Tao order
  @PostMapping("/")
  public Order makeOrder() {
    CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return orderService.createOrder(u.getUserId());
  }

  // Xoa order
  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable Integer id) {

  }
  


}

package com.example.learn.controller;

import com.example.learn.model.OrderItem;
import com.example.learn.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/order")
public class OrderItemController {
    @Autowired private OrderItemService service;

    @RequestMapping("/")
    public Collection<OrderItem> getAll(){
        Collection<OrderItem> orderItems = service.getAll();
        return orderItems;
    }

}

package com.example.learn.service;

import com.example.learn.model.OrderItem;
import com.example.learn.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderItemService {
    @Autowired private OrderItemRepository repo;
    public Collection<OrderItem> getAll(){
        return  repo.findAll();
    }

}

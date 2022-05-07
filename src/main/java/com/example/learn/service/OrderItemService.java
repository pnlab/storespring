package com.example.learn.service;

import com.example.learn.model.CartItem;
import com.example.learn.model.OrderItem;
import com.example.learn.repository.CartItemRepository;
import com.example.learn.repository.OrderItemRepository;
import com.example.learn.repository.ProductRepository;
import com.example.learn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderItemService {

    @Autowired
    private CartService cartService;

    // public Collection<OrderItem> getAll() {
    //     return orderItemService.findAll();
    // }

    public void createOrder(Integer userId, Integer orderId) {

        Collection<CartItem> cartItems = cartService.getCartItems(userId);


        // cartItems.forEach(item -> {
        //     OrderItem orderItem = new OrderItem();
        //     orderItem.setQuantity(item.getQuantity());
        //     orderItem.setProduct(item.getProduct());
        //     orderItem.setOrder(orderId);

        // }


        
    }

}

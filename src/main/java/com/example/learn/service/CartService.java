package com.example.learn.service;

import java.util.Collection;

import com.example.learn.dto.AddCartDto;
import com.example.learn.model.CartItem;
import com.example.learn.repository.CartItemRepository;

import com.example.learn.repository.ProductRepository;
import com.example.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired private CartItemRepository cartItemRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;

    public CartItem addCartItem(AddCartDto cardItem){

        
        CartItem item = new CartItem();
        item.setQuantity(cardItem.getQuantity());
        item.setProduct(productRepository.findById(cardItem.getProductId()).orElse(null));
        item.setUser(userRepository.findById(cardItem.getUserId()).orElse(null));
        System.out.println(cardItem.getQuantity());
        System.out.println(item);

        return cartItemRepository.save(item);
    }

    public Collection<CartItem> getCartItems(Integer userId){
        return cartItemRepository.findByUserId(userId);
    }

    public void delete(Integer id) {
        cartItemRepository.deleteById(id);
    }

    public void clearCart(Integer userId) {
        cartItemRepository.deleteAllByUserId(userId);
    }

}

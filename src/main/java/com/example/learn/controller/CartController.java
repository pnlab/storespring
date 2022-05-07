package com.example.learn.controller;

import java.util.Collection;

import com.example.learn.CustomUserDetails;
import com.example.learn.dto.AddCartDto;
import com.example.learn.dto.CartItemDto;
import com.example.learn.model.CartItem;
import com.example.learn.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    // Lay danh sach cac san pham trong gio hang
    @GetMapping("/")
    public Collection<CartItem> getCartItems() {
        CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<CartItem> listCartItem = cartService.getCartItems(u.getUserId());
        return listCartItem;
    }

    // Them san pham vao gio hang
    @PostMapping("/")
    public CartItem addCartItem(@RequestBody AddCartDto cardItem) {
        CartItem res = cartService.addCartItem(cardItem);
        System.out.println(cardItem);
        return res;
    }

    // Xoa san pham trong gio hang
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateQuanity(@PathVariable Integer id) {
        // TODO: update quantity
    }

}

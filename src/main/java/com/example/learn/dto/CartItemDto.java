package com.example.learn.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartItemDto implements Serializable {
    private final Integer quantity;
    private final ProductDto product;
    private final UserDto user;
}

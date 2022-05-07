package com.example.learn.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddCartDto {
  private final Integer quantity;
  private final Integer productId;
  private final Integer userId;

}

package com.example.learn.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.learn.dto.AddCartDto;
import com.example.learn.model.CartItem;
import com.example.learn.model.Order;
import com.example.learn.model.OrderItem;
import com.example.learn.repository.CartItemRepository;
import com.example.learn.repository.OrderItemRepository;
import com.example.learn.repository.OrderRepository;
import com.example.learn.repository.ProductRepository;
import com.example.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderService {
  @Autowired
  private CartItemRepository cartItemRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrderItemService orderItemService;
  @Autowired
  private CartService cartService;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;

  public Order createOrder(Integer userId) {

    Collection<CartItem> cartItems = cartService.getCartItems(userId);

    Order order = new Order();
    order.setUser(userRepository.findById(userId).orElse(null));
    order.setStatus("Pending");
    

    Collection<OrderItem> orderItems = cartItems.stream().map(cartItem -> {
      OrderItem orderItem = new OrderItem();
      orderItem.setOrder(order);
      orderItem.setProduct(cartItem.getProduct());
      orderItem.setQuantity(cartItem.getQuantity());
      orderItem.setPrice(cartItem.getProduct().getPrice());
      return orderItem;
    }).collect(Collectors.toList());


      cartService.clearCart(userId);


      order.setOrderItems(orderItems);
      Order o = orderRepository.save(order);

    
    return o;

  }

  public Order getOrder(Integer userId) {

    Order order = orderRepository.findOneByUserId(userId);

 
    return order;

  }

  public Order getOrderById(Integer userId, Integer orderId) {
    Order order = orderRepository.findById(orderId).orElse(null);

    return order;
  }

}

package com.example.learn;

import com.example.learn.model.OrderItem;
import com.example.learn.model.Product;
import com.example.learn.repository.OrderItemRepository;
import com.example.learn.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class OrderItemTests {
    @Autowired private OrderItemRepository repo;
    @Autowired private ProductRepository repoProduct;

    @Test
    public void testAddNew(){
        OrderItem orderItem = new OrderItem();
        Optional<Product> product = repoProduct.findById(1);
        orderItem.setQuantity(10);
        orderItem.setProduct(product.get());
        repo.save(orderItem);
    }
}

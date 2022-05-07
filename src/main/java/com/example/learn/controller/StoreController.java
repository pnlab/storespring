package com.example.learn.controller;

import com.example.learn.model.Product;
import com.example.learn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


// Store REST controller
@RestController
@RequestMapping("/store")
public class StoreController {
  @Autowired
  private ProductService service;

  @RequestMapping("/product")
  public Collection<Product> getAll() {
    Collection<Product> allProduct = service.getAll();
    return allProduct;
  }

  @RequestMapping("/product/{id}")
  public Optional<Product> getOne(@PathVariable Integer id) {
    Optional<Product> product = service.getById(id);
    return product;
  }

  @PostMapping(value = "/product")
  public Product createOneProduct(@RequestBody Product product) {
    // TODO: process POST request
    Product res = service.createOne(product);
    return res;
  }

  @PutMapping("/product/{id}")
  public Product update(@RequestBody Product newProduct, @PathVariable Integer id) {
    return service.update(id, newProduct);
  }

  @DeleteMapping("/product/{id}")
  public void delete(@PathVariable Integer id) {
    service.delete(id);
  }
}

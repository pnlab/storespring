package com.example.learn.service;

import com.example.learn.model.Category;
import com.example.learn.model.Product;
import com.example.learn.repository.CategoryRepository;
import com.example.learn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductRepository repo;
    @Autowired private CategoryRepository repoCate;

    public Collection<Product> getAll(){
        return (Collection<Product>) repo.findAll();
    }

    public Optional<Product> getById(Integer id){
        return repo.findById(id);
    }

    public Product createOne(Product product){
        return repo.save(product);
    }

    public Product update(Integer id, Product newProduct){
        return repo.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setDescription(newProduct.getDescription());
            product.setQuantity(newProduct.getQuantity());
            product.setUnit(newProduct.getUnit());

            Category cate = repoCate.findById(newProduct.getCategory().getId()).orElse(null);;

            product.setCategory(cate);
            return repo.save(product);
        }).orElseGet(()->{
            newProduct.setId(id);
            return repo.save(newProduct);
        });
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }


}

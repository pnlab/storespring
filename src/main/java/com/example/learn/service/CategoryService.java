package com.example.learn.service;

import java.util.Collection;
import java.util.Optional;

import com.example.learn.model.Category;
import com.example.learn.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService{
    @Autowired private CategoryRepository repo;
    public Collection<Category> getAll(){
        return (Collection<Category>) repo.findAll();
    }

    public Optional<Category> getById(Integer id) {
        return repo.findById(id);
    }

    public Category createOne(Category category) {
        return repo.save(category);
    }

    public Category update(Integer id, Category newcategory) {
        return repo.findById(id).map(category -> {
           
            return repo.save(category);
        }).orElseGet(() -> {
            newcategory.setId(id);
            return repo.save(newcategory);
        });
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }



}
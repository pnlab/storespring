package com.example.learn.controller;

import com.example.learn.model.Category;
import com.example.learn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping("/")
    public Collection<Category> getAll() {
        Collection<Category> allCategory = service.getAll();
        return allCategory;
    }

    @RequestMapping("/{id}")
    public Optional<Category> getOne(@PathVariable Integer id) {
        Optional<Category> category = service.getById(id);
        return category;
    }

    @PostMapping(value = "/")
    public Category createOneCategory(@RequestBody Category category) {
        // TODO: process POST request
        Category res = service.createOne(category);
        return res;
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category newCategory, @PathVariable Integer id) {
        return service.update(id, newCategory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

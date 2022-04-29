package com.example.learn.controller;


import java.util.Collection;

import com.example.learn.model.Category;
import com.example.learn.model.Product;
import com.example.learn.service.CategoryService;
import com.example.learn.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private  CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView showHomePage(){
        Collection<Product> allProduct = productService.getAll();

        Collection<Category> categories = categoryService.getAll();

        ModelAndView mav = new ModelAndView("index");




//        mav.addObject("greeting", "GeeksForGeeks Welcomes you to Spring!");
        mav.addObject("products", allProduct);
        mav.addObject("categories", categories);
        return mav;
    }
    @GetMapping("/login")
    public ModelAndView showLoginPage(){


        ModelAndView mav = new ModelAndView("login");


        return mav;
    }
    @GetMapping("/signup")
    public ModelAndView showRegisterPage(){


        ModelAndView mav = new ModelAndView("signup");


        return mav;
    }


    @GetMapping("/cart")
    public ModelAndView showCartPage(){


        ModelAndView mav = new ModelAndView("cart");


        return mav;
    }






}

package com.example.learn.controller;


import java.util.Collection;

import com.example.learn.model.Category;
import com.example.learn.model.Product;
import com.example.learn.model.User;
import com.example.learn.service.CategoryService;
import com.example.learn.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
//      mav.addObject("greeting", "GeeksForGeeks Welcomes you to Spring!");
        mav.addObject("products", allProduct);
        mav.addObject("categories", categories);
        return mav;
    }
    @GetMapping("/hello")
    public ModelAndView showLoginPage(){


        ModelAndView mav = new ModelAndView("login");

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return mav;
    }
    @GetMapping("/demo")
    public ModelAndView showdmPage(){


        ModelAndView mav = new ModelAndView("demo");


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
    @GetMapping("/orders")
    public ModelAndView showOrderPage(){
        ModelAndView mav = new ModelAndView("cart");


        return mav;
    }

    @GetMapping("/orders/{id}")
    public ModelAndView showOrderIdPage(){
        ModelAndView mav = new ModelAndView("cart");


        return mav;
    }


    @GetMapping("/checkout")
    public ModelAndView showCheckoutPage(){
        ModelAndView mav = new ModelAndView("cart");


        return mav;
    }


    @GetMapping("/login1")
    public ModelAndView showLogin1Page(){
        ModelAndView mav = new ModelAndView("login1");


        return mav;
    }



    private User u;

    @PostMapping("/check")
    public ModelAndView showCheckPage(@RequestBody User user){
        ModelAndView mav = new ModelAndView("check");
        mav.addObject("user", user);
        u = user;

        System.out.println(u);

        return mav;
    }

    @GetMapping("/check")
    public ModelAndView showGetCheckPage(){
        ModelAndView mav = new ModelAndView("check");
        mav.addObject("user", u);
        System.out.println(u);


        return mav;
    }










}

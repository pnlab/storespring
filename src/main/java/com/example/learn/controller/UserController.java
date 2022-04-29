package com.example.learn.controller;

import com.example.learn.model.User;
import com.example.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public List<User> showUserList(){
        List<User> all = service.listAll();
        for(User u:all){
            System.out.println(u);
        }
        return all;
    }
    @GetMapping("/user")
    public Optional<User> getUser(){
        Optional<User> user = service.getOne(1);

        return user;
    }
}

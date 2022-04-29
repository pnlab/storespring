package com.example.learn.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playground")
public class RestPlaygroundController {

    @RequestMapping("/hi")
    public String hi(){
        return "Hello playground";
    }

    @RequestMapping("/")
    public String hiUser(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello playground" + name;
    }

    @PostMapping("/")
    public String hiPost(@RequestBody String name){
        return "Hi" + name;

    }




}

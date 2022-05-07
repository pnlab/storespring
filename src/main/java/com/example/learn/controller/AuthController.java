package com.example.learn.controller;

import com.example.learn.CustomUserDetails;
import com.example.learn.dto.UserDto;
import com.example.learn.model.User;
import com.example.learn.service.UserService;
import com.example.learn.service.errors.InvalidPasswordException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Transactional
public class AuthController {
    @Autowired
    private UserService userService;



    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody UserDto userDto) {
        if (isPasswordLengthInvalid(userDto.getPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.registerUser(userDto);
        System.out.println(userDto);
    }

    private static boolean isPasswordLengthInvalid(String password) {
        return password.length() < 4;
    }



}

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
@RequestMapping("/api")
@Transactional
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showUserList() {
        List<User> all = userService.listAll();
        for (User u : all) {
            System.out.println(u);
        }
        return all;
    }

    @GetMapping("/user")
    public Optional<User> getUser() {
        Optional<User> user = userService.getOne(1);

        return user;
    }

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

    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {
         CustomUserDetails u = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.findByUsername(authentication.getName());

    }

}

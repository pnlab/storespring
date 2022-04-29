package com.example.learn.service;

import com.example.learn.model.User;
import com.example.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public Optional<User> getOne(Integer id){
        return repo.findById(id);
    }
}

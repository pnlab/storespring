package com.example.learn.repository;

import com.example.learn.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
}

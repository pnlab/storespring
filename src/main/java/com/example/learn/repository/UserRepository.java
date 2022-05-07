package com.example.learn.repository;

import com.example.learn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByUsername (String username);
    Optional<User> findOneByUsername(String username);
}

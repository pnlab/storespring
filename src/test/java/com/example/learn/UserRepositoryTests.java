package com.example.learn;

import com.example.learn.model.User;
import com.example.learn.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("pvn10092001vn@gmail.com");
        user.setPassword("123456");
        user.setFirstname("Nguyen");
        user.setLastname("Pham");

        User savedUser =repo.save(user);


        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User u: users){
            System.out.println(u);
        }

    }

    @Test
    public void updateUserAddress(){

    }

}

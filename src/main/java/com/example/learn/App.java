package com.example.learn;

import com.example.learn.model.User;
import com.example.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
//        User user = new User();
//        user.setUsername("pvn10092001");
//        user.setEmail("pvn10092001@gmail.com");
//        user.setPassword(passwordEncoder.encode("123456"));
//        user.setFirstname("Nguyen");
//        user.setLastname("Pham");
//        userRepository.save(user);
//        System.out.println(user);
//        System.out.println(passwordEncoder.encode("123456"));
    }
}
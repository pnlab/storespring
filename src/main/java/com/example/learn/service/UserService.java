package com.example.learn.service;

import com.example.learn.CustomUserDetails;
import com.example.learn.dto.UserDto;
import com.example.learn.model.User;
import com.example.learn.repository.UserRepository;
import com.example.learn.service.errors.UsernameAlreadyUsedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getOne(Integer id){
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findOneByUsername(username).orElse(null);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public User registerUser(UserDto userDto){
        userRepository
                .findOneByUsername(userDto.getUsername().toLowerCase())
                .ifPresent(existingUser -> {

                        throw new UsernameAlreadyUsedException();
                });

        User user = new User();
        user.setUsername(userDto.getUsername().toLowerCase());
        user.setEmail(userDto.getEmail().toLowerCase(Locale.ROOT));
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encryptedPassword);
        System.out.println(user);
        userRepository.save(user);
        return user ;
    }
}

package com.example.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

}

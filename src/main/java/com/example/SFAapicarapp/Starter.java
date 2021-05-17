package com.example.SFAapicarapp;

import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Starter {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public Starter(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;

        User user = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
        userService.addUser(user);
    }
}

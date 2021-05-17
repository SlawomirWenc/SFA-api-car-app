package com.example.SFAapicarapp;

import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.service.TokenService;
import com.example.SFAapicarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class Starter {

    private UserService userService;

    private TokenService tokenService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public Starter(UserService userService, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;

        User user = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
        userService.addUser(user);

        String value = UUID.randomUUID().toString();
        Token token = new Token(value, user);
        tokenService.addToken(token);

    }
}

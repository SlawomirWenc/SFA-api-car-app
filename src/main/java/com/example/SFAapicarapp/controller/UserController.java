package com.example.SFAapicarapp.controller;

import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.service.TokenService;
import com.example.SFAapicarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.util.UUID;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private TokenService tokenService;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserService userService, TokenService tokenService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/")
    public String getIndexTemplate(){
        return "index";
    }

    @GetMapping("/home")
    public String getHomeTemplate(){
        return "home";
    }

    @GetMapping("/signIn")
    public String getSignInTemplate(){
        return "signIn";
    }

    @GetMapping("/signUp")
    public String getSignUpTemplate(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String addUser(String email, String password) throws MessagingException {

        User user = new User(email, passwordEncoder.encode(password), "ROLE_USER");
        userService.addUser(user);

        String value = UUID.randomUUID().toString();
        Token token = new Token(value, user);
        tokenService.addToken(token);

       return "redirect:signIn";
    }
}

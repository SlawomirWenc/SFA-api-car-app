package com.example.SFAapicarapp.controller;

import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.service.MailService;
import com.example.SFAapicarapp.service.TokenService;
import com.example.SFAapicarapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private TokenService tokenService;

    private MailService mailService;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserService userService, TokenService tokenService, MailService mailService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.tokenService = tokenService;
        this.mailService = mailService;
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

        mailService.sendMail(email,"Confirm register: " + email, "Active your account and enjoy using api by clicking this <a href='http://localhost:8080/active?token=" + value + "'>link</a><br>", true);
        return "redirect:signIn";
    }

    @GetMapping("/active")
    public String confirmAccount(@RequestParam String token){
        Optional<Token> tempToken = tokenService.findTokenByValue(token);
        if (tempToken.isPresent()) {
            User user = tempToken.get().getUser();
            user.setEnabled(true);
            userService.addUser(user);
        }
        return "index";
    }
}

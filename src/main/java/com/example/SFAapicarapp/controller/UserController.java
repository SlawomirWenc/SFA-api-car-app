package com.example.SFAapicarapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

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
}

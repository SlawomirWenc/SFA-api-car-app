package com.example.SFAapicarapp.service;

import com.example.SFAapicarapp.model.User;
import com.example.SFAapicarapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user){
        userRepo.save(user);
    }
}

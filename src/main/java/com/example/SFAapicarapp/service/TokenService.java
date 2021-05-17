package com.example.SFAapicarapp.service;

import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private TokenRepo tokenRepo;

    @Autowired
    public TokenService(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    public void addToken(Token token){
        tokenRepo.save(token);
    }
}

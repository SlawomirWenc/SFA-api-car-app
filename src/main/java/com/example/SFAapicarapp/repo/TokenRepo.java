package com.example.SFAapicarapp.repo;

import com.example.SFAapicarapp.model.Token;
import com.example.SFAapicarapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends CrudRepository<Token, Long> {

    Optional<Token> findTokenByValue(String token);

    Optional<Token> findTokenByUser(User user);
}

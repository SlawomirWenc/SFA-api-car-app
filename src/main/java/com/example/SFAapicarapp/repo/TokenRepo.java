package com.example.SFAapicarapp.repo;

import com.example.SFAapicarapp.model.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends CrudRepository<Token, Long> {
}

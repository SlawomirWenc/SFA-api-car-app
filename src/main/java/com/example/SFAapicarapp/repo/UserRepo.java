package com.example.SFAapicarapp.repo;

import com.example.SFAapicarapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);

}

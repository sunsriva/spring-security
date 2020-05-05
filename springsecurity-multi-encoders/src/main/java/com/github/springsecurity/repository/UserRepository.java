package com.github.springsecurity.repository;

import com.github.springsecurity.model.MyUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<MyUserDetails, String> {
    Optional<MyUserDetails> findByUsername(String userName);
}

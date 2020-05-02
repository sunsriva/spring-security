package com.github.springsecurity.repository;

import com.github.springsecurity.model.UserDetailsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDetailsModel,String> {

    Optional<UserDetailsModel> findByUsername(String userName);

    List<UserDetailsModel> findAllBy();
}

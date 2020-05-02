package com.github.springsecurity.service;

import com.github.springsecurity.dto.UserCredentialsDto;
import com.github.springsecurity.model.UserDetailsModel;
import com.github.springsecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    private UserDetailsModel userDetailsModel = new UserDetailsModel();

    public UserDetailsModel registerUser(UserCredentialsDto userRequestModel) {
        userDetailsModel.setEmail(userRequestModel.getEmail());
        userDetailsModel.setRole(userRequestModel.getRole());
        userDetailsModel.setUsername(userRequestModel.getUsername());
        userDetailsModel.setPassword(passwordEncoder.encode(userRequestModel.getPassword()));
        return userRepository.save(userDetailsModel);
    }

    public Optional<UserDetailsModel> getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public List<UserDetailsModel> findAll() {
        return userRepository.findAll();
    }

}

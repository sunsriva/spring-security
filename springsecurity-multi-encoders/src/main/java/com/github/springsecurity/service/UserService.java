package com.github.springsecurity.service;

import com.github.springsecurity.mapper.UserDetailsMapper;
import com.github.springsecurity.model.MyUserDetails;
import com.github.springsecurity.model.UserCredentialsDto;
import com.github.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDetailsMapper userDetailsMapper;

    public MyUserDetails registerUser(UserCredentialsDto userDto) {

        return userRepository.save(userDetailsMapper.toUserDetails(userDto));

    }

    public Optional<MyUserDetails> getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public List<MyUserDetails> findAll() {
        return userRepository.findAll();
    }

}

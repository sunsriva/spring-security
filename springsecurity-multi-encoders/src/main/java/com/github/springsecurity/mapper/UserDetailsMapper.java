package com.github.springsecurity.mapper;

import com.github.springsecurity.model.MyUserDetails;
import com.github.springsecurity.model.UserCredentialsDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDetailsMapper {
    @Resource
    private PasswordEncoder passwordEncoder;

    public MyUserDetails toUserDetails(UserCredentialsDto userCredentialsDto) {

        return new MyUserDetails(userCredentialsDto.getUsername(), passwordEncoder.encode(userCredentialsDto.getPassword()),
                userCredentialsDto.getRoles());
    }
}

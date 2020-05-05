package com.github.springsecurity.service;

import com.github.springsecurity.model.MyUserDetails;
import com.github.springsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<MyUserDetails> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " : not found"));
        final StringBuilder roleBuilder = new StringBuilder();
        Arrays.stream(user.get().getRoles()).forEach(role-> roleBuilder.append(",").append("ROLE_").append(role));
        return new MyUserDetails(username, user.get().getPassword(), roleBuilder.substring(1).split(","));
    }
}

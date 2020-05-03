package com.github.springsecurity.controller;

import com.github.springsecurity.model.AuthenticationResponse;
import com.github.springsecurity.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userManagement/v1/")
public class HomeController {

    @Resource
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String greet() {
        return "Hello World";
    }


    @GetMapping("/token")
    public ResponseEntity<AuthenticationResponse> getToken() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}

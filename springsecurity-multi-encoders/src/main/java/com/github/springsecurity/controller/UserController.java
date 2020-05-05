package com.github.springsecurity.controller;

import com.github.springsecurity.exception.UserMismatchException;
import com.github.springsecurity.model.MyUserDetails;
import com.github.springsecurity.model.UserCredentialsDto;
import com.github.springsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<MyUserDetails> registerUser(@RequestBody UserCredentialsDto userCredentialsDto) {

        return ResponseEntity.ok(userService.registerUser(userCredentialsDto));
    }

    @RequestMapping("/userName/{userName}")
    public ResponseEntity<MyUserDetails> findByUsername(@PathVariable String userName) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUser = null;
        if (principal instanceof UserDetails) {
            loggedInUser = ((UserDetails) principal).getUsername();
        } else {
            loggedInUser = principal.toString();
        }
        if (loggedInUser == null || !loggedInUser.equals(userName))
            throw new UserMismatchException("logged is user :" + loggedInUser + " supplied user :" + userName);

        return ResponseEntity.of(userService.getUserByUserName(userName));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/all")
    public ResponseEntity<List<MyUserDetails>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }
}

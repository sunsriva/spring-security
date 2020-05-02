package com.github.springsecurity.controller;

import com.github.springsecurity.dto.UserCredentialsDto;
import com.github.springsecurity.exception.UserMismatchException;
import com.github.springsecurity.model.UserDetailsModel;
import com.github.springsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userManagement/v1/")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDetailsModel> register(@RequestBody UserCredentialsDto userCredentialsDto) {
        return ResponseEntity.ok(userService.registerUser(userCredentialsDto));
    }

    @RequestMapping("/userName/{userName}")
    public ResponseEntity<UserDetailsModel> findByUsername(@PathVariable String userName) {
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
    @RequestMapping
    public ResponseEntity<List<UserDetailsModel>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

}

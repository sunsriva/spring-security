package com.github.springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userManagement/v1/")
public class UserController {

    @GetMapping("/user")
    public String greetUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUser = null;
        if (principal instanceof UserDetails) {
            loggedInUser = ((UserDetails) principal).getUsername();
        } else {
            loggedInUser = principal.toString();
        }

        return "HelLo user : "  + loggedInUser;
    }

    @GetMapping("/admin")
    public String greetAdmin() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedInUser = null;
        if (principal instanceof UserDetails) {
            loggedInUser = ((UserDetails) principal).getUsername();
        } else {
            loggedInUser = principal.toString();
        }

        return "HelLo admin : "  + loggedInUser;
    }

}

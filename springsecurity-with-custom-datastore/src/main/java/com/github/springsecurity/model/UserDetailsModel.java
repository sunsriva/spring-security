package com.github.springsecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Document(collection = "user")
public class UserDetailsModel implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    @Field
    private String email;

    @Field
    private String role;

    @Field
    private String password;

    public UserDetailsModel() {

    }

    public UserDetailsModel(final String username, final String password,
                            final Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        final StringBuilder roleBuilder = new StringBuilder();
        authorities.forEach(auth -> roleBuilder.append(',').append(auth.getAuthority()));
        this.role = roleBuilder.substring(1);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role.split(",")).stream().map(r -> new SimpleGrantedAuthority(r.trim()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }


}

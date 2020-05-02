package com.github.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.security.SecureRandom;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/userManagement/v1/user").hasRole("USER")
                .antMatchers("/userManagement/v1/admin").hasRole("ADMIN")
                .and()
                .formLogin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* if you are using in memory database like h2, you can tell spring security to create default schema and table for
        you, by calling withDefaultSchema() as shown and populate it sample users.

               auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema().
                withUser(User.withUsername("user1").password("user1").roles("USER"))
                .withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
     */


        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        //return new BCryptPasswordEncoder(10, new SecureRandom());
        return NoOpPasswordEncoder.getInstance();
    }


}
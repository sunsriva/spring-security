package com.github.springsecurity.repository;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;
import com.github.springsecurity.model.User;

@Repository
public interface UserRepository extends LdapRepository<User> {

    User findByUsername(String username);
}

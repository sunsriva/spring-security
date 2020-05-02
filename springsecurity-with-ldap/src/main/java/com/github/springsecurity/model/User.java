package com.github.springsecurity.model;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(base = "ou=groups", objectClasses = {"person", "inetOrgPerson", "top"})
public class User {
    @Id
    private Name id;

    private @Attribute(name = "cn")
    String username;

    private @Attribute(name = "sn")
    String password;

}
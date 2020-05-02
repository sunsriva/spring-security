# Spring Security

Spring boot spring-security project using custom data store to retrieve info by UserDetailsService. 
This project  allows to register user with different roles and a user can check only his/her details but user with ADMIN roles
can check other users details too.

Dependency:

```$xslt
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

This project enclose Postman- Collection. You can import and test the application.
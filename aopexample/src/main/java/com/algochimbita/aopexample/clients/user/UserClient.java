package com.algochimbita.aopexample.clients.user;

import org.springframework.stereotype.Component;

@Component
public class UserClient {

    public User getUser() {
        return User.builder().firstName("armando").lastName("porros").age(33).build();
    }

}

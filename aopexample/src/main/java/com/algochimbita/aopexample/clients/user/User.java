package com.algochimbita.aopexample.clients.user;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private String firstName;
    private String lastName;
    private Integer age;

}



package com.algochimbita.aopexample.domain;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UserInfo {

    private String name;
    private String customerName;
    private String customerId;
    private CustomerProfile profile;

}

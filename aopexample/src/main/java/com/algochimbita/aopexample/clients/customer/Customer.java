package com.algochimbita.aopexample.clients.customer;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Customer {

    private String custormerId;
    private String customerName;

}

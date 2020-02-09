package com.algochimbita.aopexample.clients.customer;

import com.algochimbita.aopexample.aop.AuditInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomerClient {

    @AuditInterceptor
    public Customer getCustomer() {
        return Customer.builder().customerName("elhumos").custormerId("0064681").build();
    }
}

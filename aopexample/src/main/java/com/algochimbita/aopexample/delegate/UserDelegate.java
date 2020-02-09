package com.algochimbita.aopexample.delegate;

import com.algochimbita.aopexample.aop.AuditInterceptor;
import com.algochimbita.aopexample.clients.customer.Customer;
import com.algochimbita.aopexample.clients.customer.CustomerClient;
import com.algochimbita.aopexample.clients.user.User;
import com.algochimbita.aopexample.clients.user.UserClient;
import com.algochimbita.aopexample.domain.CustomerProfile;
import com.algochimbita.aopexample.domain.UserInfo;
import com.algochimbita.aopexample.domain.exceptions.UserInformationNoAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDelegate {

    private final UserClient userClient;
    private final CustomerClient customerClient;

    @Autowired
    public UserDelegate(UserClient userClient, CustomerClient customerClient) {
        this.userClient = userClient;
        this.customerClient = customerClient;
    }

    public UserInfo getUserInfo(){
        User user = null;
        Customer customer;
        try {
            user = retrieveUserfromClient();
        } catch (UserInformationNoAvailableException e) {
            e.printStackTrace();
        }
        customer = getCustomerInfo();
        return UserInfo.builder()
                .name(user.getFirstName().concat(" ").concat(user.getLastName()))
                .customerName("el humos")
                .customerId(customer.getCustormerId())
                .profile(user.getAge() > 16 ? CustomerProfile.ADULT : CustomerProfile.CHILD)
                .build();
    }

    private Customer getCustomerInfo() {
        return customerClient.getCustomer();
    }


    private User retrieveUserfromClient() throws UserInformationNoAvailableException {
        Optional<User> optionalUser = Optional.ofNullable(userClient.getUser());
        return optionalUser.orElseThrow(() -> new UserInformationNoAvailableException());
    }
}

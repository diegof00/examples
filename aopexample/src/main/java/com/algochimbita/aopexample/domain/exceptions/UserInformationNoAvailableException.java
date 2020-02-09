package com.algochimbita.aopexample.domain.exceptions;

public class UserInformationNoAvailableException extends Exception{

    private static final String NO_USER_INFO_MESSAGE = "no user info ...";

    public UserInformationNoAvailableException() {
        super(NO_USER_INFO_MESSAGE);
    }
}

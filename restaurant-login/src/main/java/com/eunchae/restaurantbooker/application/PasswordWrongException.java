package com.eunchae.restaurantbooker.application;

public class PasswordWrongException extends RuntimeException{
    PasswordWrongException() {
        super("Password is wrong");
    }
}

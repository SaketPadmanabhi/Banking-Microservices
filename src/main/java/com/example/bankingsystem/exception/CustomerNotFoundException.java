package com.example.bankingsystem.exception;

public class CustomerNotFoundException extends RuntimeException {
    //Allows unchecked exception handling.
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
//Helps return meaningful errors.
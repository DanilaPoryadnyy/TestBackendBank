package com.example.testbackendbank.exception;


public class UserInstanceNotFound extends RuntimeException {
    public UserInstanceNotFound(String message) {
        super(message);
    }
}

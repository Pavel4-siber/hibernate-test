package com.example.hibernatetest.exception;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

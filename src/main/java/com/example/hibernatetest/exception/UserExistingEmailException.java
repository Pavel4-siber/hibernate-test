package com.example.hibernatetest.exception;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
public class UserExistingEmailException extends Throwable {

    public UserExistingEmailException(String message) {
        super(message);
    }

    public UserExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}

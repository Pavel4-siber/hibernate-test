package com.example.hibernatetest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.http.HttpClient;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
        UserException userException = new UserException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException, userException.getStatus());
    }

    @ExceptionHandler(value = UserExistingEmailException.class)
    public ResponseEntity<Object> handleUserExistingEmailException(UserExistingEmailException e){
        UserException userException = new UserException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException, userException.getStatus());
    }
}

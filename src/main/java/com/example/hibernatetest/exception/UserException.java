package com.example.hibernatetest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */
@Data
@AllArgsConstructor
public class UserException {

    private String msg;
    private Throwable throwable;
    private HttpStatus status;
}

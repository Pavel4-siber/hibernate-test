package com.example.hibernatetest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhurenkov Pavel 25.07.2023
 */
public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String msg, HttpStatus status, Object body){
        Map<String, Object> response = new HashMap<>();
        response.put("Message", msg);
        response.put("Status", status);
        response.put("Body", body);
        return new ResponseEntity<>(response, status);
    }
}

package com.example.hibernatetest.service;

import com.example.hibernatetest.model.User;
import org.springframework.http.ResponseEntity;

/**
 * @author Zhurenkov Pavel 25.07.2023
 */
public interface UserService {

    ResponseEntity<Object> save(User user);

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> findAll();

    ResponseEntity<Object> updateUser(Long id);
}

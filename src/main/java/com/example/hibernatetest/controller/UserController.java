package com.example.hibernatetest.controller;

import com.example.hibernatetest.model.User;
import com.example.hibernatetest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zhurenkov Pavel 25.07.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable("id") Long id){
        return userService.updateUser(id);
    }
}

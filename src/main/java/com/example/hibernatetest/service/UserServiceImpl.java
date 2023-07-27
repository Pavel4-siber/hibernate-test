package com.example.hibernatetest.service;

import com.example.hibernatetest.exception.UserExistingEmailException;
import com.example.hibernatetest.exception.UserNotFoundException;
import com.example.hibernatetest.handler.ResponseHandler;
import com.example.hibernatetest.model.User;
import com.example.hibernatetest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Zhurenkov Pavel 27.07.2023
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    @Transactional
    public ResponseEntity<Object> save(User user) {
        Optional<User> userOptional = findByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new UserExistingEmailException("There is user with the same email");
        }
        Long id = userRepository.save(user).getId();
        return ResponseHandler.responseBuilder("User save", HttpStatus.OK, id);
    }

    private Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @SneakyThrows
    public ResponseEntity<Object> findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            throw new UserNotFoundException("User does not exists");
        }
        return ResponseHandler.responseBuilder("Searched user", HttpStatus.OK, user.get());
    }

    @Override
    public ResponseEntity<Object> findAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            return ResponseHandler.responseBuilder("Collection is empty", HttpStatus.NOT_FOUND, "[]");
        }
            return ResponseHandler.responseBuilder("Find all users", HttpStatus.OK, users);
    }

    @Override
    @Transactional
    @SneakyThrows
    public ResponseEntity<Object> updateUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new UserNotFoundException("User does not exists");
        }
        User currentUser = user.get();
        Map<String, Object> updateResponse = new HashMap<>();
        updateResponse.put("id", currentUser.getId());
        updateResponse.put("Previous status", currentUser.getActive());
        if (currentUser.getActive()){
            currentUser.setActive(false);
        } else {
            currentUser.setActive(true);
        }
        updateResponse.put("Current status", currentUser.getActive());
        User persistUser = userRepository.save(currentUser);

        return ResponseHandler.responseBuilder("User was update", HttpStatus.OK, persistUser.getId());
    }
}

package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    // Get all users
    List<UserDTO> getAllUsers();

    // Get a user by ID
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id);

    // Create a new user
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);
}

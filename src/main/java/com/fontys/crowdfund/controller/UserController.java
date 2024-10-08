package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.GetDTOUser;
import com.fontys.crowdfund.persistence.dto.PostDTOUser;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    // Get all users
    List<GetDTOUser> getAllUsers();

    // Get a user by ID
    ResponseEntity<GetDTOUser> getUserById(@PathVariable Long id);

    // Create a new user
    ResponseEntity<GetDTOUser> createUser(@RequestBody PostDTOUser postDTOUser);
}

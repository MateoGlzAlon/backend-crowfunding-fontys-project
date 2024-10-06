package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.UserDTO;

import java.util.List;

public interface UserService {

    // Get all users and convert them to DTOs
    List<UserDTO> getAllUsers();

    // Get user by ID
    UserDTO getUserById(long id);

    // Create a new user
    UserDTO createUser(UserDTO userDTO);

}

package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by ID
    boolean existsById(long userId);

    // Find a user by ID
    UserDTO findById(long userId);

    // Find a user by ID
    UserDTO findByEmail(String userEmail);

    // Save a user (create or update)
    UserDTO save(UserDTO user);

    // Find all users
    List<UserDTO> findAll();

    // Get the count of users
    int count();
}

package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by ID
    boolean existsById(long userId);

    // Find a user by ID
    Optional<UserDTO> findById(long userId);

    // Save a user (create or update)
    UserDTO save(UserDTO user);

    // Find all users
    List<UserDTO> findAll();

    // Get the count of users
    int count();
}

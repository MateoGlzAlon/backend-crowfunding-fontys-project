package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.OutputDTOUser;

import java.util.List;

public interface UserRepository {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by ID
    boolean existsById(int userId);

    // Find a user by ID
    OutputDTOUser findById(int userId);

    // Find a OutputDTOUser by ID
    OutputDTOUser findByEmail(String userEmail);

    // Find a User by ID
    User findUserByEmail(String userEmail);

    // Save a user (create or update)
    OutputDTOUser save(User user);

    // Find all users
    List<OutputDTOUser> findAll();

    // Get the count of users
    int count();

    OutputDTOUser deleteById(int id);
}

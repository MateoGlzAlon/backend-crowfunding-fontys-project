package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.GetDTOUser;
import com.fontys.crowdfund.persistence.dto.PostDTOUser;
import com.fontys.crowdfund.persistence.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by ID
    boolean existsById(long userId);

    // Find a user by ID
    GetDTOUser findById(long userId);

    // Find a GetDTOUser by ID
    GetDTOUser findByEmail(String userEmail);

    // Find a User by ID
    User findUserByEmail(String userEmail);

    // Save a user (create or update)
    GetDTOUser save(User user);

    // Find all users
    List<GetDTOUser> findAll();

    // Get the count of users
    int count();

    GetDTOUser deleteById(int id);
}

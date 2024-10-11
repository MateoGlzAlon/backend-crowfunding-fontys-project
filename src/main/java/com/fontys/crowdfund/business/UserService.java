package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.InputDTOUser;

import java.util.List;

public interface UserService {

    // Get all users and convert them to DTOs
    List<OutputDTOUser> getAllUsers();

    // Get user by ID
    OutputDTOUser getUserById(int id);

    // Create a new user
    OutputDTOUser createUser(InputDTOUser userDTO);

    OutputDTOUser deleteUser(int id);
}

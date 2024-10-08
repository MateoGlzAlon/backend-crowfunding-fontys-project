package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.GetDTOUser;
import com.fontys.crowdfund.persistence.dto.PostDTOUser;
import com.fontys.crowdfund.persistence.dto.UserDTO;

import java.util.List;

public interface UserService {

    // Get all users and convert them to DTOs
    List<GetDTOUser> getAllUsers();

    // Get user by ID
    GetDTOUser getUserById(long id);

    // Create a new user
    GetDTOUser createUser(PostDTOUser userDTO);

}

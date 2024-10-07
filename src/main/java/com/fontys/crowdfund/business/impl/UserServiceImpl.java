package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import com.fontys.crowdfund.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Get all users and convert them to DTOs
    @Override
    public List<UserDTO> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    // Get user by ID
    @Override
    public UserDTO getUserById(long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .id(userDTO.getId())
                .build();

        System.out.println("User Details:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("ID: " + user.getId());

        return userRepository.save(convertToDTO(user));
    }

    // Convert User entity to DTO
    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}

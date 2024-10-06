package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import com.fontys.crowdfund.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users and convert them to DTOs
    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get user by ID
    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    // Create a new user
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .created(userDTO.getCreated())
                .build();

        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    // Convert User entity to DTO
    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .created(user.getCreated())
                .build();
    }
}

package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.exception.EmailAlreadyExists;
import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.InputDTOUser;
import com.fontys.crowdfund.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Get all users and convert them to DTOs
    @Override
    public List<OutputDTOUser> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    // Get user by ID
    @Override
    public OutputDTOUser getUserById(int id) {
        return userRepository.findById(id);
    }

    // Create a new user
    @Override
    public OutputDTOUser createUser(InputDTOUser userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new EmailAlreadyExists();
        }

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .ownedProjects(new ArrayList<>())
                .build();

        return userRepository.save(user);
    }

    @Override
    public OutputDTOUser deleteUser(int id) {

        return userRepository.deleteById(id);

    }



}

package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.exception.EmailAlreadyExists;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOUser;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // Get all users and convert them to DTOs
    @Override
    public List<OutputDTOUser> getAllUsers() {
        List<OutputDTOUser> outputDTOUsers = new ArrayList<>();

        for (UserEntity userEntity : userRepository.findAll()) {
            outputDTOUsers.add(createOutputDTOUser(userEntity));
        }

        return outputDTOUsers;
    }

    // Get user by ID
    @Override
    public OutputDTOUser getUserById(int id) {
        return createOutputDTOUser(userRepository.findById(id));
    }

    // Create a new user
    @Override
    public OutputDTOUser createUser(InputDTOUser userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new EmailAlreadyExists();
        }
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        UserEntity user = UserEntity.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(encodedPassword)
                .projects(new HashSet<>())
                .role(userDTO.getRole())
                .build();

        return createOutputDTOUser(userRepository.save(user));
    }

    @Override
    public void deleteUser(int id) {

        userRepository.deleteById(id);

    }


    public OutputDTOUser createOutputDTOUser(UserEntity userEntity) {

        return OutputDTOUser.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .role(userEntity.getRole())
                .build();

    }



}

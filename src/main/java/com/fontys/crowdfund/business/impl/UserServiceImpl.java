package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserService;
import com.fontys.crowdfund.exception.EmailAlreadyExists;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOUser;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOUser;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import com.fontys.crowdfund.persistence.specialdto.UserProjectDTO;
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
            //CHECK : Ensure userEntity is not null before converting to OutputDTOUser
            outputDTOUsers.add(createOutputDTOUser(userEntity));
        }

        return outputDTOUsers;
    }

    // Get user by ID
    @Override
    public OutputDTOUser getUserById(int id) {
        //CHECK : Check if the user exists in the repository. If not, throw an exception.
        return createOutputDTOUser(userRepository.findById(id));
    }

    // Create a new user
    @Override
    public OutputDTOUser createUser(InputDTOUser userDTO) {
        //CHECK : Validate input data, e.g., ensure email and password are not null or empty.
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new EmailAlreadyExists(); //CHECK : Ensure EmailAlreadyExists exception includes a proper error message.
        }

        //CHECK : Verify passwordEncoder does not throw an exception for invalid input.
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        UserEntity user = UserEntity.builder()
                .name(userDTO.getName()) //CHECK : Ensure name is not null or empty.
                .email(userDTO.getEmail()) //CHECK : Validate email format if required.
                .password(encodedPassword)
                .projects(new HashSet<>()) //CHECK : If projects need to be pre-set, validate them here.
                .role(userDTO.getRole()) //CHECK : Validate role to ensure it matches expected roles (e.g., "USER", "ADMIN").
                .profilePicture(userDTO.getProfilePicture()) //CHECK : Validate profile picture URL if necessary.
                .build();

        //CHECK : Ensure the save operation succeeds without throwing exceptions.
        return createOutputDTOUser(userRepository.save(user));
    }

    @Override
    public void deleteUser(int id) {
        //CHECK : Validate if the user with the given ID exists before deleting.
        userRepository.deleteById(id);
    }

    @Override
    public UserProjectDTO getUserDataForProject(int id) {
        //CHECK : Ensure the project data for the given user exists, otherwise return a meaningful error.
        return userRepository.getUserDataForProject(id);
    }

    @Override
    public Integer getUserIdFromEmail(String email) {
        //CHECK : Validate email is not null or empty and follows the correct format.
        return userRepository.getUserIdFromEmail(email);
    }

    public OutputDTOUser createOutputDTOUser(UserEntity userEntity) {
        //CHECK : Ensure userEntity is not null to avoid NullPointerException.
        return OutputDTOUser.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .role(userEntity.getRole())
                .profilePicture(userEntity.getProfilePicture())
                .build();
    }
}

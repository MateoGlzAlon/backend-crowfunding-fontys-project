package com.fontys.crowdfund.business.impl;


import com.fontys.crowdfund.business.CreateUserUseCase;
import com.fontys.crowdfund.business.UserIdValidator;
import com.fontys.crowdfund.business.exception.UserException;
import com.fontys.crowdfund.domain.CreateUserRequest;
import com.fontys.crowdfund.domain.CreateUserResponse;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsById(request.getId())) {
            throw new UserException("USER_ALREADY_EXISTS");
        }

        UserEntity savedUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .build();
    }

    private UserEntity saveNewUser(CreateUserRequest request) {

        UserEntity newUser = UserEntity.builder()
                .id(request.getId())
                .email(request.getEmail())
                .build();
        return userRepository.save(newUser);
    }



}



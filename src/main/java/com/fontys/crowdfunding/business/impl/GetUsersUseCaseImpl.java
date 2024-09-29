package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.business.GetUsersUseCase;
import com.fontys.crowdfunding.domain.User;
import com.fontys.crowdfunding.domain.GetUsersResponse;
import com.fontys.crowdfunding.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final UserRepository userRepository;

    @Override
    public GetUsersResponse getUsers() {
        List<User> users = userRepository.findAll()
                .stream()
                .map(UserConverter::convert)
                .toList();

        return GetUsersResponse.builder()
                .users(users)
                .build();
    }
}

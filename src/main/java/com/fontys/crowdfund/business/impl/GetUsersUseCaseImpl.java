package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.GetUsersUseCase;
import com.fontys.crowdfund.domain.User;
import com.fontys.crowdfund.domain.GetUsersResponse;
import com.fontys.crowdfund.persistence.UserRepository;
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

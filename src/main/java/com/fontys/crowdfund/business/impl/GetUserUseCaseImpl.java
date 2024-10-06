package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.GetUserUseCase;
import com.fontys.crowdfund.domain.User;
import com.fontys.crowdfund.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(long userId) {
        return userRepository.findById(userId).map(UserConverter::convert);
    }
}

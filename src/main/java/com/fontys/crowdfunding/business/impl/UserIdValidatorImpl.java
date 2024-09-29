package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.business.UserIdValidator;
import com.fontys.crowdfunding.business.exception.InvalidUserException;
import com.fontys.crowdfunding.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIdValidatorImpl implements UserIdValidator {
    private final UserRepository userRepository;

    @Override
    public void validateId(Long userId) {
        if (userId == null || !userRepository.existsById(userId)) {
            throw new InvalidUserException();
        }
    }
}

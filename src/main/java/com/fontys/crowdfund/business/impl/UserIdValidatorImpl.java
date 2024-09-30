package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserIdValidator;
import com.fontys.crowdfund.business.exception.InvalidUserException;
import com.fontys.crowdfund.persistence.UserRepository;
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

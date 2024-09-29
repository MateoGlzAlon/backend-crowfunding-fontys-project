package com.fontys.crowdfunding.business;

import com.fontys.crowdfunding.business.exception.InvalidUserException;

public interface UserIdValidator {
    void validateId(Long userId) throws InvalidUserException;
}

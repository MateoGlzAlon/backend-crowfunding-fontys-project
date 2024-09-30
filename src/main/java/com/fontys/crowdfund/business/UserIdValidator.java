package com.fontys.crowdfund.business;

import com.fontys.crowdfund.business.exception.InvalidUserException;

public interface UserIdValidator {
    void validateId(Long userId) throws InvalidUserException;
}

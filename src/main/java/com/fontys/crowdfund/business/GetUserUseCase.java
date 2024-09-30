package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> getUser(long userId);
}

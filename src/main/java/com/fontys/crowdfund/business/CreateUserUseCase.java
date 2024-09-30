package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.CreateUserRequest;
import com.fontys.crowdfund.domain.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
}

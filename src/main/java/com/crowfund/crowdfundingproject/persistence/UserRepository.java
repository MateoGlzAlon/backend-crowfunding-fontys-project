package com.crowfund.crowdfundingproject.persistence;

import com.crowfund.crowdfundingproject.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    boolean existsByEmail(String email);

    boolean existsById(long userId);

    UserEntity findById(long userId);

    UserEntity save(UserEntity country);

    List<UserEntity> findAll();

    int count();
}

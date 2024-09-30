package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    boolean existsByEmail(String email);

    boolean existsById(long userId);

    UserEntity findById(long userId);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    int count();
}

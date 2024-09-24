package com.crowfund.crowdfundingproject.persistence.impl;

import com.crowfund.crowdfundingproject.persistence.UserRepository;
import com.crowfund.crowdfundingproject.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeUserRepositoryImpl implements UserRepository {
    private static long NEXT_ID = 1;

    private final List<UserEntity> savedUsers;

    public FakeUserRepositoryImpl() {
        this.savedUsers = new ArrayList<>();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.savedUsers
                .stream()
                .anyMatch(userEntity -> userEntity.getEmail().equals(email));
    }

    @Override
    public boolean existsById(long countryId) {
        return this.savedUsers
                .stream()
                .anyMatch(userEntity -> userEntity.getId().equals(countryId));
    }

    @Override
    public UserEntity findById(long userId) {
        return this.savedUsers
                .stream()
                .filter(countryEntity -> countryEntity.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public UserEntity save(UserEntity user) {
        user.setId(NEXT_ID);
        NEXT_ID++;
        this.savedUsers.add(user);
        return user;
    }

    @Override

    public List<UserEntity> findAll() {
        return Collections.unmodifiableList(savedUsers);
    }

    @Override
    public int count() {
        return this.savedUsers.size();
    }
}

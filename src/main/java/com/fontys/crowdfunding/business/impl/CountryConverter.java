package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.domain.User;
import com.fontys.crowdfunding.persistence.entity.UserEntity;

final class UserConverter {
    private UserConverter() {
    }

    public static User convert(UserEntity user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}

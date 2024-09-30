package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.domain.User;
import com.fontys.crowdfund.persistence.entity.UserEntity;

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

package com.fontys.crowdfund.business.impl;


import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.dto.UserDTO;

final class UserConverter {
    private UserConverter() {
    }

    public static User convert(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}

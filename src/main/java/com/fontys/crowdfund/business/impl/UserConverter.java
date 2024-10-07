package com.fontys.crowdfund.business.impl;


import com.fontys.crowdfund.model.User;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.UserDTO;
import com.fontys.crowdfund.persistence.impl.UserRepositoryImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
final class UserConverter {

    UserRepository userRepository;

    public static User convert(UserDTO user) {

        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password("TO-DO")
                .build();
    }
}

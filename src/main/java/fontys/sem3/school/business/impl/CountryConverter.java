package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.User;
import fontys.sem3.school.persistence.entity.UserEntity;

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

package com.fontys.crowdfunding.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserEntity {
    private long id;
    private String name;
    private String email;
    private String password;
}

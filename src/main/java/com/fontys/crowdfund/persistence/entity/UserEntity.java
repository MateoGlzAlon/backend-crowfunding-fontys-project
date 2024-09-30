package com.fontys.crowdfund.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private long id;
    private String name;
    private String email;
    private String password;

}

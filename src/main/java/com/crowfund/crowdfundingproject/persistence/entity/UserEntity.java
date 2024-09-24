package com.crowfund.crowdfundingproject.persistence.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserEntity {
    private Long id;
    private Long email;
    private String name;
    private String password;
}

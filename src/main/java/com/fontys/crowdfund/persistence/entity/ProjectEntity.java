package com.fontys.crowdfund.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectEntity {
    private Long id;
    private String name;
    private UserEntity user;
}

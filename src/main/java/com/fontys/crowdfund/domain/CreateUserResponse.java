package com.fontys.crowdfund.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
    private Long userId;
    private String email;
}

package com.fontys.crowdfund.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetUsersResponse {
    private List<User> users;
}

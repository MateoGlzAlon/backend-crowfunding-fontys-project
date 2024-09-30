package com.fontys.crowdfund.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProjectResponse {
    private Long projectId;
}

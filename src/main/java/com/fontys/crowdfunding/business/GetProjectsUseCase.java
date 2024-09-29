package com.fontys.crowdfunding.business;

import com.fontys.crowdfunding.domain.GetAllProjectsRequest;
import com.fontys.crowdfunding.domain.GetAllProjectsResponse;

public interface GetProjectsUseCase {
    GetAllProjectsResponse getProjects(GetAllProjectsRequest request);
}

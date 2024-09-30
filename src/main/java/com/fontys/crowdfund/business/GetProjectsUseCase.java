package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.GetAllProjectsRequest;
import com.fontys.crowdfund.domain.GetAllProjectsResponse;

public interface GetProjectsUseCase {
    GetAllProjectsResponse getProjects(GetAllProjectsRequest request);
}

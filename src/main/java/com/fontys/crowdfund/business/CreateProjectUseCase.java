package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.CreateProjectRequest;
import com.fontys.crowdfund.domain.CreateProjectResponse;

public interface CreateProjectUseCase {
    CreateProjectResponse createProject(CreateProjectRequest request);
}

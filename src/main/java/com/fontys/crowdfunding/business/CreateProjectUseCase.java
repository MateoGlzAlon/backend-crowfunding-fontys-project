package com.fontys.crowdfunding.business;

import com.fontys.crowdfunding.domain.CreateProjectRequest;
import com.fontys.crowdfunding.domain.CreateProjectResponse;

public interface CreateProjectUseCase {
    CreateProjectResponse createProject(CreateProjectRequest request);
}

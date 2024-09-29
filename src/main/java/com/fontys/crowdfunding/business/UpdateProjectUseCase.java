package com.fontys.crowdfunding.business;

import com.fontys.crowdfunding.domain.UpdateProjectRequest;

public interface UpdateProjectUseCase {
    void updateProject(UpdateProjectRequest request);
}

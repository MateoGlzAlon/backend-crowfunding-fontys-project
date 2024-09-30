package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.UpdateProjectRequest;

public interface UpdateProjectUseCase {
    void updateProject(UpdateProjectRequest request);
}

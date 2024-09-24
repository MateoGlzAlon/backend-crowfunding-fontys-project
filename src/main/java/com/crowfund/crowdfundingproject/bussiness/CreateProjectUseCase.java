package com.crowfund.crowdfundingproject.bussiness;

import com.crowfund.crowdfundingproject.domain.CreateProjectRequest;
import com.crowfund.crowdfundingproject.domain.CreateProjectResponse;

public interface CreateProjectUseCase {

    CreateProjectResponse createProject(CreateProjectRequest request);

}

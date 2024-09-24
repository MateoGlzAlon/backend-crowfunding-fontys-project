package com.crowfund.crowdfundingproject.bussiness;

import com.crowfund.crowdfundingproject.domain.Project;
import java.util.Optional;

public interface GetProjectUseCase {
    Optional<Project> getProject(long projectId);
}



package com.fontys.crowdfund.business;

import com.fontys.crowdfund.domain.Project;

import java.util.Optional;

public interface GetProjectUseCase {
    Optional<Project> getProject(long projectId);
}

package com.fontys.crowdfunding.business;

import com.fontys.crowdfunding.domain.Project;

import java.util.Optional;

public interface GetProjectUseCase {
    Optional<Project> getProject(long projectId);
}

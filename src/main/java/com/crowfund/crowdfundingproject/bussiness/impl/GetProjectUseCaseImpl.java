package com.crowfund.crowdfundingproject.bussiness.impl;

import com.crowfund.crowdfundingproject.bussiness.GetProjectUseCase;
import com.crowfund.crowdfundingproject.domain.Project;
import com.crowfund.crowdfundingproject.persistence.ProjectRepository;

import java.util.Optional;

public class GetProjectUseCaseImpl implements GetProjectUseCase {

    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProject(long projectId) {

        return projectRepository.findById(projectId).map(ProjectConverter::convert);


    }
}

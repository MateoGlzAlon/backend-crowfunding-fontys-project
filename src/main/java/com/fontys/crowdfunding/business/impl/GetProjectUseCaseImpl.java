package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.business.GetProjectUseCase;
import com.fontys.crowdfunding.domain.Project;
import com.fontys.crowdfunding.persistence.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetProjectUseCaseImpl implements GetProjectUseCase {

    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProject(long projectId) {
        return projectRepository.findById(projectId).map(ProjectConverter::convert);
    }
}

package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.GetProjectUseCase;
import com.fontys.crowdfund.domain.Project;
import com.fontys.crowdfund.persistence.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetProjectUseCaseImpl implements GetProjectUseCase {

    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProject(long projectId) {
        System.out.println(ProjectConverter.class);
        return projectRepository.findById(projectId).map(ProjectConverter::convert);
    }
}

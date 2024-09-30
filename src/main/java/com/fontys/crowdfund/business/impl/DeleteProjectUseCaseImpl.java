package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.DeleteProjectUseCase;
import com.fontys.crowdfund.persistence.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {
    private final ProjectRepository projectRepository;

    @Override
    public void deleteProject(long projectId) {
        this.projectRepository.deleteById(projectId);
    }
}

package com.crowfund.crowdfundingproject.bussiness.impl;

import com.crowfund.crowdfundingproject.bussiness.CreateProjectUseCase;
import com.crowfund.crowdfundingproject.domain.CreateProjectRequest;
import com.crowfund.crowdfundingproject.domain.CreateProjectResponse;
import com.crowfund.crowdfundingproject.persistence.ProjectRepository;
import com.crowfund.crowdfundingproject.persistence.UserRepository;
import com.crowfund.crowdfundingproject.persistence.entity.ProjectEntity;
import com.crowfund.crowdfundingproject.bussiness.exception.ProjectIdAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;


    @Override
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        if (projectRepository.existsById(request.getId())) {
            //throw new ProyectIdAlreadyExistsException("");
        }

        ProjectEntity savedProject = saveNewProject(request);

        return CreateProjectResponse.builder()
                .projectId(savedProject.getId())
                .projectName(savedProject.getName())
                .build();
    }

    private ProjectEntity saveNewProject(CreateProjectRequest request) {

        ProjectEntity newProject = ProjectEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
        return projectRepository.save(newProject);
    }
}

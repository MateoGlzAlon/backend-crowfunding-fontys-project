package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.UserIdValidator;
import com.fontys.crowdfund.business.CreateProjectUseCase;
import com.fontys.crowdfund.business.exception.ProjectException;
import com.fontys.crowdfund.domain.CreateProjectRequest;
import com.fontys.crowdfund.domain.CreateProjectResponse;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    @Override
    public CreateProjectResponse createProject(CreateProjectRequest request) {
        if (projectRepository.existsById(request.getId())) {
            throw new ProjectException("PROJECT ALREADY EXISTS");
        }

        //userIdValidator.validateId(request.getUserId());

        ProjectEntity savedProject = saveNewProject(request);

        return CreateProjectResponse.builder()
                .projectId(savedProject.getId())
                .build();
    }

    private ProjectEntity saveNewProject(CreateProjectRequest request) {
        UserEntity userEntity = userRepository.findById(request.getUserId()).stream().findFirst().orElse(null);

        ProjectEntity newProject = ProjectEntity.builder()
                .user(userEntity)
                .name(request.getName())
                .build();
        return projectRepository.save(newProject);
    }
}

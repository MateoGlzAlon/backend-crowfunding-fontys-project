package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.business.UserIdValidator;
import com.fontys.crowdfunding.business.CreateProjectUseCase;
import com.fontys.crowdfunding.business.exception.PcnAlreadyExistsException;
import com.fontys.crowdfunding.domain.CreateProjectRequest;
import com.fontys.crowdfunding.domain.CreateProjectResponse;
import com.fontys.crowdfunding.persistence.UserRepository;
import com.fontys.crowdfunding.persistence.ProjectRepository;
import com.fontys.crowdfunding.persistence.entity.UserEntity;
import com.fontys.crowdfunding.persistence.entity.ProjectEntity;
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
            throw new PcnAlreadyExistsException();
        }

        userIdValidator.validateId(request.getUserId());

        ProjectEntity savedProject = saveNewProject(request);

        return CreateProjectResponse.builder()
                .projectId(savedProject.getId())
                .build();
    }

    private ProjectEntity saveNewProject(CreateProjectRequest request) {
        UserEntity userEntity = userRepository.findById(request.getUserId());

        ProjectEntity newProject = ProjectEntity.builder()
                .user(userEntity)
                .name(request.getName())
                .build();
        return projectRepository.save(newProject);
    }
}

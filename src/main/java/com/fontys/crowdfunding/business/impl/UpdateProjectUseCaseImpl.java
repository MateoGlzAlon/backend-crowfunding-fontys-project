package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.business.UserIdValidator;
import com.fontys.crowdfunding.business.UpdateProjectUseCase;
import com.fontys.crowdfunding.business.exception.InvalidProjectException;
import com.fontys.crowdfunding.domain.UpdateProjectRequest;
import com.fontys.crowdfunding.persistence.UserRepository;
import com.fontys.crowdfunding.persistence.ProjectRepository;
import com.fontys.crowdfunding.persistence.entity.UserEntity;
import com.fontys.crowdfunding.persistence.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    @Override
    public void updateProject(UpdateProjectRequest request) {
        Optional<ProjectEntity> projectOptional = projectRepository.findById(request.getId());
        if (projectOptional.isEmpty()) {
            throw new InvalidProjectException("PROJECT_ID_INVALID");
        }

        userIdValidator.validateId(request.getUserId());

        ProjectEntity project = projectOptional.get();
        updateFields(request, project);
    }

    private void updateFields(UpdateProjectRequest request, ProjectEntity project) {
        UserEntity userEntity = userRepository.findById(request.getUserId());
        project.setUser(userEntity);
        project.setName(request.getName());

        projectRepository.save(project);
    }
}

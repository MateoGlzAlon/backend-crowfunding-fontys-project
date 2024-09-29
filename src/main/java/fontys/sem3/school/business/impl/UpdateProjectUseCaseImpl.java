package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UserIdValidator;
import fontys.sem3.school.business.UpdateProjectUseCase;
import fontys.sem3.school.business.exception.InvalidProjectException;
import fontys.sem3.school.domain.UpdateProjectRequest;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.ProjectRepository;
import fontys.sem3.school.persistence.entity.UserEntity;
import fontys.sem3.school.persistence.entity.ProjectEntity;
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

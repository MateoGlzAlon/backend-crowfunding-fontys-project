package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UserIdValidator;
import fontys.sem3.school.business.CreateProjectUseCase;
import fontys.sem3.school.business.exception.PcnAlreadyExistsException;
import fontys.sem3.school.domain.CreateProjectRequest;
import fontys.sem3.school.domain.CreateProjectResponse;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.ProjectRepository;
import fontys.sem3.school.persistence.entity.UserEntity;
import fontys.sem3.school.persistence.entity.ProjectEntity;
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

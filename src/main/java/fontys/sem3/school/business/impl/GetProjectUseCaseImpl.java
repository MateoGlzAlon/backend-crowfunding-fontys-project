package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetProjectUseCase;
import fontys.sem3.school.domain.Project;
import fontys.sem3.school.persistence.ProjectRepository;
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

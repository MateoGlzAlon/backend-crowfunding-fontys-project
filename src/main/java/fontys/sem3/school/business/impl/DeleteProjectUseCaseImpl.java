package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.DeleteProjectUseCase;
import fontys.sem3.school.persistence.ProjectRepository;
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

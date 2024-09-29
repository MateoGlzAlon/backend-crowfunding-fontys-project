package fontys.sem3.school.business;

import fontys.sem3.school.domain.Project;

import java.util.Optional;

public interface GetProjectUseCase {
    Optional<Project> getProject(long projectId);
}

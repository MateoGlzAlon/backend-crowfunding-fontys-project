package fontys.sem3.school.business;

import fontys.sem3.school.domain.CreateProjectRequest;
import fontys.sem3.school.domain.CreateProjectResponse;

public interface CreateProjectUseCase {
    CreateProjectResponse createProject(CreateProjectRequest request);
}

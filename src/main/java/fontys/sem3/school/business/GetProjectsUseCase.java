package fontys.sem3.school.business;

import fontys.sem3.school.domain.GetAllProjectsRequest;
import fontys.sem3.school.domain.GetAllProjectsResponse;

public interface GetProjectsUseCase {
    GetAllProjectsResponse getProjects(GetAllProjectsRequest request);
}

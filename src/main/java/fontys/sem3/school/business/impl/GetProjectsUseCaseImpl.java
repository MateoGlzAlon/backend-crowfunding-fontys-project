package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetProjectsUseCase;
import fontys.sem3.school.domain.GetAllProjectsRequest;
import fontys.sem3.school.domain.GetAllProjectsResponse;
import fontys.sem3.school.domain.Project;
import fontys.sem3.school.persistence.ProjectRepository;
import fontys.sem3.school.persistence.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class GetProjectsUseCaseImpl implements GetProjectsUseCase {
    private ProjectRepository projectRepository;

    @Override
    public GetAllProjectsResponse getProjects(final GetAllProjectsRequest request) {
        List<ProjectEntity> results;
        if (StringUtils.hasText(request.getUserCode())) {
            results = projectRepository.findAllByUserEmail(request.getUserCode());
        } else {
            results = projectRepository.findAll();
        }

        final GetAllProjectsResponse response = new GetAllProjectsResponse();
        List<Project> projects = results
                .stream()
                .map(ProjectConverter::convert)
                .toList();
        response.setProjects(projects);

        return response;
    }
}

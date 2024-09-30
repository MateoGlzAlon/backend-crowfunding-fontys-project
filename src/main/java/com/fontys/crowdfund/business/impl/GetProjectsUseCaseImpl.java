package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.GetProjectsUseCase;
import com.fontys.crowdfund.domain.GetAllProjectsRequest;
import com.fontys.crowdfund.domain.GetAllProjectsResponse;
import com.fontys.crowdfund.domain.Project;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
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

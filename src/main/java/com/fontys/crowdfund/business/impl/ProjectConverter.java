package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;

final class ProjectConverter {
    private ProjectConverter() {

    }

    public static Project convert(ProjectDTO project) {
        return Project.builder()
                .id(project.getId())
                .name(project.getName())
                .owner(UserConverter.convert(project.getUser()))
                .build();
    }
}

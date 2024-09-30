package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.domain.Project;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;

final class ProjectConverter {
    private ProjectConverter() {

    }

    public static Project convert(ProjectEntity project) {
        return Project.builder()
                .id(project.getId())
                .name(project.getName())
                .owner(UserConverter.convert(project.getUser()))
                .build();
    }
}

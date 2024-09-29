package com.fontys.crowdfunding.business.impl;

import com.fontys.crowdfunding.domain.Project;
import com.fontys.crowdfunding.persistence.entity.ProjectEntity;

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

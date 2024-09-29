package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Project;
import fontys.sem3.school.persistence.entity.ProjectEntity;

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

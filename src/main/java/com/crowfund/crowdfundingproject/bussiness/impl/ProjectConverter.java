package com.crowfund.crowdfundingproject.bussiness.impl;

import com.crowfund.crowdfundingproject.domain.Project;
import com.crowfund.crowdfundingproject.persistence.entity.ProjectEntity;
import com.crowfund.crowdfundingproject.persistence.UserRepository;
import lombok.Builder;

import java.util.Date;

@Builder
public class ProjectConverter {

    private final UserRepository userRepository;

    public static Project convert(ProjectEntity project) {
        return Project.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .location(project.getLocation())
                .type(project.getType())
                .created(new Date())
                .ownerEmail(project.getOwnerEmail())
                .build();
    }

}
package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import com.fontys.crowdfund.persistence.impl.UserRepositoryImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
final class ProjectConverter {

    private final UserRepository userRepository;

    public static Project convert(ProjectDTO project) {

        UserRepository userRepository = new UserRepositoryImpl();


        System.out.println("Project converter: " + project);

        return Project.builder()
                .id(project.getId())
                .name(project.getName())
                .owner(UserConverter.convert(userRepository.findById(project.getId())))
                .build();
    }
}

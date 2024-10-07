package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.model.User;

import com.fontys.crowdfund.model.Project;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {


    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;


    // Get all projects and convert them to DTOs
    public List<ProjectDTO> getAllProjects() {
        return new ArrayList<>(projectRepository.findAll());
    }

    // Get project by ID
    public ProjectDTO getProjectById(long id) {
        return projectRepository.findById(id);
    }

    // Create a new project and link it to a user by userId
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        User owner = UserConverter.convert(userRepository.findByEmail(projectDTO.getUserEmail()));

        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .location(projectDTO.getLocation())
                .type(projectDTO.getType())
                .created(projectDTO.getCreated())
                .owner(owner)  // Linking project to the user
                .build();

        return projectRepository.save(convertToDTO(project));
    }

    // Convert Project entity to DTO
    private ProjectDTO convertToDTO(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .location(project.getLocation())
                .type(project.getType())
                .created(project.getCreated())
                .userEmail(project.getOwner().getEmail())  // Converting owner relation
                .build();
    }
}

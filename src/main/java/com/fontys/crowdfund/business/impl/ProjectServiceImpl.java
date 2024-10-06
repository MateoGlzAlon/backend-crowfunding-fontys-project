package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.model.Project;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    // Get all projects and convert them to DTOs
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get project by ID
    public ProjectDTO getProjectById(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return convertToDTO(project);
    }

    // Create a new project and link it to a user by userId
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        User owner = userRepository.findById(projectDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .location(projectDTO.getLocation())
                .type(projectDTO.getType())
                .created(projectDTO.getCreated())
                .owner(owner)  // Linking project to the user
                .build();

        Project savedProject = projectRepository.save(project);
        return convertToDTO(savedProject);
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
                .userId(project.getOwner().getId())  // Converting owner relation
                .build();
    }
}

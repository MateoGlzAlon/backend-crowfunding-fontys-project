package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    // Get all projects and convert them to DTOs
    List<ProjectDTO> getAllProjects();

    // Get project by ID
    ProjectDTO getProjectById(long id);

    // Create a new project and link it to a user by userId
    ProjectDTO createProject(ProjectDTO projectDTO);

}

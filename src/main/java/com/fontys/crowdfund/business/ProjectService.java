package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.PostDTOProject;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    // Get all projects and convert them to DTOs
    List<GetDTOProject> getAllProjects();

    // Get project by ID
    GetDTOProject getProjectById(int id);

    // Create a new project and link it to a user by userId
    GetDTOProject createProject(PostDTOProject projectDTO);

}

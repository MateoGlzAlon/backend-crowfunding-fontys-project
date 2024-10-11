package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.InputDTOProject;

import java.util.List;

public interface ProjectService {

    // Get all projects and convert them to DTOs
    List<OutputDTOProject> getAllProjects();

    // Get project by ID
    OutputDTOProject getProjectById(int id);

    // Create a new project and link it to a user by userId
    OutputDTOProject createProject(InputDTOProject projectDTO);

    OutputDTOProject deleteProject(int id);

    List<OutputDTOProject> getCloseToFundingAllProjects();

    List<OutputDTOProject> getNewProjects();
}

package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.dto.OutputDTOProject;

import java.util.List;

public interface ProjectRepository {

    // Check if a project exists by its ID
    boolean existsById(int id);

    // Find all projects by user email
    List<OutputDTOProject> findAllProjectsByUserEmail(String userEmail);

    // Find a project by its ID
    OutputDTOProject findById(int projectId);

    // Delete a project by its ID
    OutputDTOProject deleteById(int projectId);

    // Save a project (create or update)
    OutputDTOProject save(Project project);

    List<OutputDTOProject> findAll();

    List<OutputDTOProject> getCloseToFundingProjects();

    boolean projectExists(String name, String userEmail);

    List<OutputDTOProject> getNewProjects();
}

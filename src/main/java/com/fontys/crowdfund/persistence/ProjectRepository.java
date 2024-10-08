package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;

import java.util.List;

public interface ProjectRepository {

    // Check if a project exists by its ID
    boolean existsById(int id);

    // Find all projects by user email
    List<GetDTOProject> findAllProjectsByUserEmail(String userEmail);

    // Find a project by its ID
    GetDTOProject findById(int projectId);

    // Delete a project by its ID
    void deleteById(Long projectId);

    // Save a project (create or update)
    GetDTOProject save(Project project);
    // Find all projects

    List<GetDTOProject> findAll();

}

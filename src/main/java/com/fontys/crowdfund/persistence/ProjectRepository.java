package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    // Check if a project exists by its ID
    boolean existsById(Long id);

    // Find all projects by user email
    List<ProjectDTO> findAllByUserEmail(String userEmail);

    // Save a project (create or update)
    ProjectDTO save(ProjectDTO project);

    // Delete a project by its ID
    void deleteById(Long projectId);

    // Find all projects
    List<ProjectDTO> findAll();

    // Find a project by its ID
    Optional<ProjectDTO> findById(Long projectId);
}

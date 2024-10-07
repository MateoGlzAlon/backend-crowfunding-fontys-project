package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectController {

    // Get all projects
    ResponseEntity<List<ProjectDTO>> getAllProjects();

    // Get a project by its ID
    ResponseEntity<ProjectDTO> getProjectById(@PathVariable long id);

    // Create a new project
    ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO);
}

package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.PostDTOProject;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectController {

    // Get all projects
    ResponseEntity<List<GetDTOProject>> getAllProjects();

    // Get a project by its ID
    ResponseEntity<GetDTOProject> getProjectById(@PathVariable int id);

    // Create a new project
    ResponseEntity<GetDTOProject> createProject(@RequestBody PostDTOProject projectDTO);
}

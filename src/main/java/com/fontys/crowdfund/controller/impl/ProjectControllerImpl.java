package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import com.fontys.crowdfund.business.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectControllerImpl implements ProjectController {

    private ProjectService projectService;

    // Get all projects
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    // Create a new project
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }
}

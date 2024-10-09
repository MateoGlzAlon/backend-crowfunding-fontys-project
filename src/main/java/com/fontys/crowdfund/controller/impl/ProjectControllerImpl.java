
package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.ProjectController;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.PostDTOProject;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import com.fontys.crowdfund.business.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<GetDTOProject>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetDTOProject> getProjectById(@PathVariable int id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<GetDTOProject> createProject(@RequestBody PostDTOProject projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GetDTOProject> deleteProject(@PathVariable int id) {
        return ResponseEntity.ok(projectService.deleteProject(id));
    }

    @GetMapping("/highlighted")
    public ResponseEntity<List<GetDTOProject>> getCloseToFundingProjects() {
        return ResponseEntity.ok(projectService.getCloseToFundingAllProjects());
    }

    @GetMapping("/new")
    public ResponseEntity<List<GetDTOProject>> getNewProjects() {
        return ResponseEntity.ok(projectService.getNewProjects());
    }
}

package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.ProjectController;
import com.fontys.crowdfund.persistence.dto.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.InputDTOProject;
import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.dto.OutputDTOProjectImage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @Override
    @GetMapping
    public ResponseEntity<List<OutputDTOProject>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OutputDTOProject> getProjectById(@PathVariable int id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<OutputDTOProject> createProject(@RequestBody InputDTOProject projectDTO) {
        return ResponseEntity.ok(projectService.createProject(projectDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<OutputDTOProject> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/highlighted")
    public ResponseEntity<List<OutputDTOProject>> getCloseToFundingProjects() {
        return ResponseEntity.ok(projectService.getCloseToFundingAllProjects());
    }

    @Override
    @GetMapping("/new")
    public ResponseEntity<List<OutputDTOProject>> getNewProjects() {
        return ResponseEntity.ok(projectService.getNewProjects());
    }





    @Override
    @GetMapping("/images")
    public ResponseEntity<List<OutputDTOProjectImage>> getAllProjectImages() {
        return ResponseEntity.ok(projectService.getAllProjectImages());
    }

    @Override
    @PostMapping("/images")
    public ResponseEntity<OutputDTOProjectImage> createProjectImage(@RequestBody InputDTOProjectImage projectDTOImage) {
        return ResponseEntity.ok(projectService.createProjectImage(projectDTOImage));
    }

    @Override
    @GetMapping("/images/{id}")
    public ResponseEntity<OutputDTOProjectImage> getProjectImageById(@PathVariable int id) {
        return ResponseEntity.ok(projectService.getProjectImageById(id));
    }

    @Override
    @DeleteMapping("/images/{id}")
    public ResponseEntity<OutputDTOProjectImage> deleteProjectImage(@PathVariable int id) {
        projectService.deleteProjectImage(id);
        return ResponseEntity.ok().build();
    }


}

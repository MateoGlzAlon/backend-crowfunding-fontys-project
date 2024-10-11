// ProjectController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.InputDTOProject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProjectController {

    @GetMapping
    ResponseEntity<List<OutputDTOProject>> getAllProjects();

    @GetMapping("/{id}")
    ResponseEntity<OutputDTOProject> getProjectById(@PathVariable int id);

    @PostMapping
    ResponseEntity<OutputDTOProject> createProject(@RequestBody InputDTOProject projectDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOProject> deleteProject(@PathVariable int id);

    @GetMapping("/highlighted")
    ResponseEntity<List<OutputDTOProject>> getCloseToFundingProjects();

    @GetMapping("/new")
    ResponseEntity<List<OutputDTOProject>> getNewProjects();
}

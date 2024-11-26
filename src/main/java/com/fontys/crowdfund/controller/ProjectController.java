// ProjectController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProjectImage;
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

    @GetMapping("/new")
    ResponseEntity<List<OutputDTOProject>> getProjectsFromUserID(int userId);


    //=================================00

    @GetMapping("/images")
    ResponseEntity<List<OutputDTOProjectImage>> getAllProjectImages();

    @PostMapping("/images")
    ResponseEntity<OutputDTOProjectImage> createProjectImage(@RequestBody InputDTOProjectImage projectDTOImage);

    @GetMapping("/images/{id}")
    ResponseEntity<OutputDTOProjectImage> getProjectImageById(@PathVariable int id);

    @DeleteMapping("/images/{id}")
    ResponseEntity<OutputDTOProjectImage> deleteProjectImage(@PathVariable int id);

}

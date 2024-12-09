// ProjectController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProjectImage;
import com.fontys.crowdfund.persistence.specialdto.ProjectDetailsDTO;
import com.fontys.crowdfund.persistence.specialdto.ProjectOnlyCoverLandingPage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    ResponseEntity<List<ProjectOnlyCoverLandingPage>> getCloseToFundingProjects();

    @GetMapping("/new")
    ResponseEntity<List<ProjectOnlyCoverLandingPage>> getNewProjects();

    @GetMapping("/filters/pagination")
    ResponseEntity<Map<String, Object>> getAllProjectsForLandingPage(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double minPercentageFunded,
            @RequestParam(required = false) Double maxPercentageFunded,
            @RequestParam(defaultValue = "dateCreated") String sortBy,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "") String name);

    @GetMapping("/users/{id}")
    ResponseEntity<List<OutputDTOProject>> getProjectsFromUserID(int userId);

    @GetMapping("/users/id/{id}")
    ResponseEntity<List<Integer>> getProjectIdsFromUserID(int userId);

    @GetMapping("/details/{id}")
    ResponseEntity<ProjectDetailsDTO> getProjectDetailsByID(@PathVariable int id);




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

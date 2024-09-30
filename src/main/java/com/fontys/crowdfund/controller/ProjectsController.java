package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.business.*;
import com.fontys.crowdfund.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectsController {
    private final GetProjectUseCase getProjectUseCase;
    private final GetProjectsUseCase getProjectsUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final CreateProjectUseCase createProjectUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;


    @GetMapping("{id}")
    public ResponseEntity<Project> getProject(@PathVariable(value = "id") final long id) {
        final Optional<Project> projectOptional = getProjectUseCase.getProject(id);
        if (projectOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(projectOptional.get());
    }



    @GetMapping
    public ResponseEntity<GetAllProjectsResponse> getAllProjects(@RequestParam(value = "user", required = false) String userCode) {
        GetAllProjectsRequest request = GetAllProjectsRequest.builder().userCode(userCode).build();
        GetAllProjectsResponse response = getProjectsUseCase.getProjects(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable int projectId) {
        deleteProjectUseCase.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody @Valid CreateProjectRequest request) {
        CreateProjectResponse response = createProjectUseCase.createProject(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateProject(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateProjectRequest request) {
        request.setId(id);
        updateProjectUseCase.updateProject(request);
        return ResponseEntity.noContent().build();
    }
}

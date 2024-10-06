package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private static Long NEXT_ID = 1L;
    private final List<ProjectDTO> savedProjects;

    public ProjectRepositoryImpl() {
        this.savedProjects = new ArrayList<>();
    }

    @Override
    public boolean existsById(Long id) {
        return this.savedProjects
                .stream()
                .anyMatch(ProjectDTO -> ProjectDTO.getId().equals(id));
    }

    @Override
    public List<ProjectDTO> findAllByUserEmail(String userEmail) {
        return this.savedProjects
                .stream()
                .filter(ProjectDTO -> ProjectDTO.getUser().getEmail().equals(userEmail))
                .toList();
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if (project.getId() == null) {
            project.setId(NEXT_ID);
            NEXT_ID++;
            this.savedProjects.add(project);
        }
        return project;
    }

    @Override
    public void deleteById(Long projectId) {
        this.savedProjects.removeIf(ProjectDTO -> ProjectDTO.getId().equals(projectId));
    }

    @Override
    public List<ProjectDTO> findAll() {
        return Collections.unmodifiableList(this.savedProjects);
    }

    @Override
    public Optional<ProjectDTO> findById(Long projectId) {
        return this.savedProjects.stream()
                .filter(ProjectDTO -> ProjectDTO.getId().equals(projectId))
                .findFirst();
    }
}

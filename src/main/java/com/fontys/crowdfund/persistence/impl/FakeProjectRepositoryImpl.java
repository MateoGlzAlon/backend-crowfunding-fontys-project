package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeProjectRepositoryImpl implements ProjectRepository {
    private static long NEXT_ID = 1;
    private final List<ProjectEntity> savedProjects;

    public FakeProjectRepositoryImpl() {
        this.savedProjects = new ArrayList<>();
    }

    @Override
    public boolean existsById(long id) {
        return this.savedProjects
                .stream()
                .anyMatch(projectEntity -> projectEntity.getId().equals(id));
    }

    @Override
    public List<ProjectEntity> findAllByUserEmail(String userEmail) {
        return this.savedProjects
                .stream()
                .filter(projectEntity -> projectEntity.getUser().getEmail().equals(userEmail))
                .toList();
    }

    @Override
    public ProjectEntity save(ProjectEntity project) {
        if (project.getId() == null) {
            project.setId(NEXT_ID);
            NEXT_ID++;
            this.savedProjects.add(project);
        }
        return project;
    }

    @Override
    public void deleteById(long projectId) {
        this.savedProjects.removeIf(projectEntity -> projectEntity.getId().equals(projectId));
    }

    @Override
    public List<ProjectEntity> findAll() {
        return Collections.unmodifiableList(this.savedProjects);
    }

    @Override
    public Optional<ProjectEntity> findById(long projectId) {
        return this.savedProjects.stream()
                .filter(projectEntity -> projectEntity.getId().equals(projectId))
                .findFirst();
    }
}

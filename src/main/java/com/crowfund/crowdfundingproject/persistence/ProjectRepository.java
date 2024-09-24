package com.crowfund.crowdfundingproject.persistence;

import com.crowfund.crowdfundingproject.persistence.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    boolean existsById(long projectId);

    List<ProjectEntity> findAllByProjectType(String projectType);

    ProjectEntity save(ProjectEntity Project);

    void deleteById(long projectId);

    List<ProjectEntity> findAll();

    Optional<ProjectEntity> findById(long projectId);
}

package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    boolean existsById(long id);

    List<ProjectEntity> findAllByUserEmail(String userCode);

    ProjectEntity save(ProjectEntity project);

    void deleteById(long projectId);

    List<ProjectEntity> findAll();

    Optional<ProjectEntity> findById(long projectId);
}

package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.entity.ProjectImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectImagesRepository extends JpaRepository<ProjectImageEntity, Integer> {

    // Retrieve only image URLs for a specific project by project ID
    @Query("SELECT pi.imageUrl " +
            "FROM ProjectImageEntity pi " +
            "WHERE pi.project.id = :projectId " +
            "ORDER BY pi.id DESC")
    List<String> getImagesFromProjectId(@Param("projectId") Integer projectId);
}

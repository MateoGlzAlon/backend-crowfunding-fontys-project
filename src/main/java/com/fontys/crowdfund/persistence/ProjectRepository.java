package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    // Check if a project exists by its ID
    @Query("SELECT COUNT(p) > 0 " +
            "FROM ProjectEntity p " +
            "WHERE p.id = :id")
    boolean existsById(@Param("id") int id);

    // Find all projects by user email
    @Query("SELECT new com.fontys.crowdfund.persistence.entity.ProjectEntity(p.id, p.name, p.description, p.location, p.type, p.dateCreated, p.fundingGoal, p.moneyRaised) " +
            "FROM ProjectEntity p " +
            "JOIN p.user u " +
            "WHERE u.email = :userEmail")
    List<ProjectEntity> findAllProjectsByUserEmail(@Param("userEmail") String userEmail);

    // Delete a project by its ID
    @Modifying
    @Transactional
    @Query("DELETE FROM ProjectEntity p " +
            "WHERE p.id = :projectId")
    void deleteById(@Param("projectId") int projectId);

    // Get projects close to reaching funding goals (e.g., 90% of the goal)
    @Query("SELECT p " +
            "FROM ProjectEntity p " +
            "WHERE p.moneyRaised < p.fundingGoal " +
            "ORDER BY p.moneyRaised/p.fundingGoal DESC " +
            "LIMIT 5 ")
    List<ProjectEntity> getCloseToFundingProjects();

    // Get new projects, ordered by creation date (assuming 'new' means most recently created)
    @Query("SELECT p " +
            "FROM ProjectEntity p " +
            "ORDER BY p.dateCreated DESC " +
            "LIMIT 5")
    List<ProjectEntity> getNewProjects();


    @Query("SELECT p " +
            "FROM ProjectEntity p " +
            "WHERE p.user.id =:userId " +
            "ORDER BY p.dateCreated ")
    List<ProjectEntity> findProjectsByUserId(@Param("userId")int userId);
}

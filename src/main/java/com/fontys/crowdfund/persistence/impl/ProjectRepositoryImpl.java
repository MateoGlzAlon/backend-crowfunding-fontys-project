package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    private static int NEXT_ID = 1;
    private final List<Project> savedProjects;


    public ProjectRepositoryImpl() {
        this.savedProjects = new ArrayList<>();
    }

    @Override
    public boolean existsById(int id) {
        return this.savedProjects
                .stream()
                .anyMatch(ProjectDTO -> ProjectDTO.getId() ==  id);
    }

    @Override
    public List<GetDTOProject> findAllProjectsByUserEmail(String userEmail) {

        List<GetDTOProject> dtoProjects = new ArrayList<>();

        for (Project project : this.savedProjects) {
            if(project.getOwner().getEmail().equals(userEmail)) {
                dtoProjects.add(GetDTOProject.builder()
                        .id(project.getId())
                        .userEmail(project.getOwner().getEmail())
                        .name(project.getName())
                        .moneyRaised(project.getMoneyRaised())
                        .fundingGoal(project.getFundingGoal())
                        .build());
            }
        }

       return dtoProjects;

    }


    @Override
    public GetDTOProject save(Project project) {
            project.setId(NEXT_ID);
            NEXT_ID++;
            this.savedProjects.add(project);

        return GetDTOProject.builder()
                .id(project.getId())
                .name(project.getName())
                .userEmail(project.getOwner().getEmail())
                .moneyRaised(project.getMoneyRaised())
                .fundingGoal(project.getFundingGoal())
                .build();
    }

    @Override
    public GetDTOProject deleteById(int projectId) {
        for (Project project : this.savedProjects) {
            if (project.getId() == projectId) {
                this.savedProjects.remove(project);
                return GetDTOProject.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .userEmail(project.getOwner().getEmail())
                        .moneyRaised(project.getMoneyRaised())
                        .fundingGoal(project.getFundingGoal())
                        .build();
            }
        }
        // Optionally return null or throw an exception if the project was not found
        return null; // or throw new ProjectNotFoundException("Project not found with id: " + projectId);
    }


    @Override
    public List<GetDTOProject> findAll() {

        List<GetDTOProject> dtoProjects = new ArrayList<>();

        for (Project project : this.savedProjects) {
            GetDTOProject dtoProject = GetDTOProject.builder()
                    .id(project.getId())
                    .name(project.getName())
                    .userEmail(project.getOwner().getEmail())
                    .moneyRaised(project.getMoneyRaised())
                    .fundingGoal(project.getFundingGoal())
                    .build();

            dtoProjects.add(dtoProject);
        }

        // Return an unmodifiable list of DTOs
        return Collections.unmodifiableList(dtoProjects);
    }


    @Override
    public GetDTOProject findById(int projectId) {
        Project project = this.savedProjects.stream()
                .filter(projectDTO -> projectDTO.getId() == projectId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));

        return GetDTOProject.builder().
                id(project.getId())
                .name(project.getName())
                .userEmail(project.getOwner().getEmail())
                .moneyRaised(project.getMoneyRaised())
                .fundingGoal(project.getFundingGoal())
                .build();
    }

}

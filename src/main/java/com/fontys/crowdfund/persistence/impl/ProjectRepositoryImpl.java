package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.Project;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                .anyMatch(project -> project.getId() == id);
    }

    @Override
    public List<GetDTOProject> findAllProjectsByUserEmail(String userEmail) {
        return this.savedProjects.stream()
                .filter(project -> project.getOwner().getEmail().equals(userEmail))
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList());
    }

    @Override
    public GetDTOProject save(Project project) {
        project.setId(NEXT_ID);
        NEXT_ID++;
        this.savedProjects.add(project);
        return convertToDTO(project); // Convert and return the saved project
    }

    @Override
    public GetDTOProject deleteById(int projectId) {
        for (Project project : this.savedProjects) {
            if (project.getId() == projectId) {
                this.savedProjects.remove(project);
                return convertToDTO(project); // Use the utility method for conversion
            }
        }
        return null; // Optionally return null or throw an exception if the project was not found
    }

    @Override
    public List<GetDTOProject> findAll() {
        return this.savedProjects.stream()
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList());
    }

    @Override
    public List<GetDTOProject> getCloseToFundingProjects() {
        return this.savedProjects.stream()
                .filter(project -> project.getMoneyRaised() < project.getFundingGoal()) // Filter projects
                .sorted(Comparator.comparingDouble(project -> project.getFundingGoal() - project.getMoneyRaised())) // Sort by closeness to goal
                .limit(5) // Limit the results to a maximum of 5 projects
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList()); // Collect and return as a List
    }

    @Override
    public boolean projectExists(String name, String userEmail) {
        return this.savedProjects.stream()
                .anyMatch(project -> project.getName().equals(name) && project.getOwner().getEmail().equals(userEmail));
    }

    @Override
    public List<GetDTOProject> getNewProjects() {
        return this.savedProjects.stream()
                .sorted((project1, project2) -> project2.getDateCreated().compareTo(project1.getDateCreated())) // Sort by date in descending order
                .limit(5) // Limit to the 5 most recent projects
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList()); // Collect and return as a List
    }

    @Override
    public GetDTOProject findById(int projectId) {
        Project project = this.savedProjects.stream()
                .filter(projectDTO -> projectDTO.getId() == projectId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));

        return convertToDTO(project); // Use the utility method for conversion
    }

    // Utility method to convert Project to GetDTOProject
    private GetDTOProject convertToDTO(Project project) {
        return GetDTOProject.builder()
                .id(project.getId())
                .name(project.getName())
                .type(project.getType())
                .description(project.getDescription())
                .location(project.getLocation())
                .dateCreated(project.getDateCreated())
                .userEmail(project.getOwner().getEmail())
                .moneyRaised(project.getMoneyRaised())
                .fundingGoal(project.getFundingGoal())
                .images(project.getImages())
                .build();
    }
}

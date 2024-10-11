package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.exception.ProjectAlreadyExists;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.OutputDTOProject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.model.User;

import com.fontys.crowdfund.model.Project;

import com.fontys.crowdfund.persistence.dto.InputDTOProject;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;


    // Get all projects and convert them to DTOs
    public List<OutputDTOProject> getAllProjects() {
        return new ArrayList<>(projectRepository.findAll());
    }

    // Get project by ID
    public OutputDTOProject getProjectById(int id) {
        return projectRepository.findById(id);
    }

    // Create a new project and link it to a user by userId
    public OutputDTOProject createProject(InputDTOProject postDTOProject) {

        if(projectRepository.projectExists(postDTOProject.getName(), postDTOProject.getUserEmail())){
            throw new ProjectAlreadyExists();
        }

        User owner = userRepository.findUserByEmail(postDTOProject.getUserEmail());

        System.out.println("dateCraetd " + postDTOProject.getDateCreated());

        Project project = Project.builder()
                .name(postDTOProject.getName())
                .description(postDTOProject.getDescription())
                .location(postDTOProject.getLocation())
                .type(postDTOProject.getType())
                .dateCreated(postDTOProject.getDateCreated())
                .moneyRaised(0)
                .fundingGoal(postDTOProject.getFundingGoal())
                .owner(owner)  // Linking project to the user
                .fundings(new ArrayList<>())
                .images(postDTOProject.getImages())
                .build();

        return projectRepository.save(project);
    }

    @Override
    public OutputDTOProject deleteProject(int id) {
        return projectRepository.deleteById(id);
    }

    @Override
    public List<OutputDTOProject> getCloseToFundingAllProjects() {
        return projectRepository.getCloseToFundingProjects();
    }

    @Override
    public List<OutputDTOProject> getNewProjects() {
        return projectRepository.getNewProjects();
    }
}

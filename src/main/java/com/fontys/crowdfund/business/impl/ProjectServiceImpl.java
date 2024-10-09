package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.exception.ProjectAlreadyExists;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.model.User;

import com.fontys.crowdfund.model.Project;

import com.fontys.crowdfund.persistence.dto.GetDTOProject;
import com.fontys.crowdfund.persistence.dto.PostDTOProject;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;


    // Get all projects and convert them to DTOs
    public List<GetDTOProject> getAllProjects() {
        return new ArrayList<>(projectRepository.findAll());
    }

    // Get project by ID
    public GetDTOProject getProjectById(int id) {
        return projectRepository.findById(id);
    }

    // Create a new project and link it to a user by userId
    public GetDTOProject createProject(PostDTOProject postDTOProject) {

        if(projectRepository.projectExists(postDTOProject.getName(), postDTOProject.getUserEmail())){
            throw new ProjectAlreadyExists();
        }

        User owner = userRepository.findUserByEmail(postDTOProject.getUserEmail());

        Project project = Project.builder()
                .name(postDTOProject.getName())
                .description(postDTOProject.getDescription())
                .location(postDTOProject.getLocation())
                .type(postDTOProject.getType())
                .created(postDTOProject.getCreated())
                .moneyRaised(0)
                .fundingGoal(postDTOProject.getFundingGoal())
                .owner(owner)  // Linking project to the user
                .fundings(new ArrayList<>())
                .images(postDTOProject.getImages())
                .build();

        return projectRepository.save(project);
    }

    @Override
    public GetDTOProject deleteProject(int id) {
        return projectRepository.deleteById(id);
    }

    @Override
    public List<GetDTOProject> getCloseToFundingAllProjects() {
        return projectRepository.getCloseToFundingProjects();
    }

    @Override
    public List<GetDTOProject> getNewProjects() {
        return projectRepository.getNewProjects();
    }
}

package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.dto.ProjectDTO;
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
                .build();

        return projectRepository.save(project);
    }

    @Override
    public GetDTOProject deleteProject(int id) {

        return projectRepository.deleteById(id);

    }


}

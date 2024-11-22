package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.ProjectImagesRepository;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProjectImage;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.ProjectImageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectImagesRepository projectImagesRepository;


    // Get all projects and convert them to DTOs
    public List<OutputDTOProject> getAllProjects() {

        List<OutputDTOProject> outputDTOProjects = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.findAll()) {
            outputDTOProjects.add(createOutputDTOProject(projectEntity));
        }

        return outputDTOProjects;

    }

    // Get project by ID
    public OutputDTOProject getProjectById(int id) {
        return createOutputDTOProject(Objects.requireNonNull(projectRepository.findById(id).orElse(null)));
    }

    // Create a new project and link it to a user by userId
    public OutputDTOProject createProject(InputDTOProject postDTOProject) {

        ProjectEntity project = ProjectEntity.builder()
                .name(postDTOProject.getName())
                .description(postDTOProject.getDescription())
                .location(postDTOProject.getLocation())
                .type(postDTOProject.getType())
                .dateCreated(postDTOProject.getDateCreated())
                .moneyRaised(0f)
                .fundingGoal(postDTOProject.getFundingGoal())
                .user(userRepository.findByEmail(postDTOProject.getUserEmail()))  // Linking project to the user
                .build();

        return createOutputDTOProject(projectRepository.save(project));
    }

    @Override
    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<OutputDTOProject> getCloseToFundingAllProjects() {

        List<OutputDTOProject> outputDTOProjects = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.getCloseToFundingProjects()) {
            outputDTOProjects.add(createOutputDTOProject(projectEntity));
        }

        return outputDTOProjects;

    }

    @Override
    public List<OutputDTOProject> getNewProjects() {

        List<OutputDTOProject> outputDTOProjects = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.getNewProjects()) {
            outputDTOProjects.add(createOutputDTOProject(projectEntity));
        }

        return outputDTOProjects;
    }

    @Override
    public List<OutputDTOProjectImage> getAllProjectImages() {

        List<OutputDTOProjectImage> outputDTOProjectImages = new ArrayList<>();

        for (ProjectImageEntity projectImageEntity : projectImagesRepository.findAll()) {
            outputDTOProjectImages.add(createOutputDTOProjectImage(projectImageEntity));
        }

        return outputDTOProjectImages;    }

    @Override
    public OutputDTOProjectImage createProjectImage(InputDTOProjectImage projectDTOImage) {

        ProjectImageEntity projectImage = ProjectImageEntity.builder()
                .project(projectRepository.findById(projectDTOImage.getProjectId()).orElse(null))
                .imageUrl(projectDTOImage.getImageURL())
                .imageOrder(projectDTOImage.getImageOrder())
                .build();

        return createOutputDTOProjectImage(projectImagesRepository.save(projectImage));
    }

    @Override
    public OutputDTOProjectImage getProjectImageById(int id) {
        return createOutputDTOProjectImage(Objects.requireNonNull(projectImagesRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteProjectImage(int id) {
        projectImagesRepository.deleteById(id);
    }


    public OutputDTOProject createOutputDTOProject(ProjectEntity projectEntity) {

        return OutputDTOProject.builder()

                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .userEmail(projectEntity.getUser().getEmail())
                .fundingGoal(projectEntity.getFundingGoal())
                .moneyRaised(projectEntity.getMoneyRaised())
                .images(projectImagesRepository.getImagesFromProjectId(projectEntity.getId()))
                .description(projectEntity.getDescription())
                .location(projectEntity.getLocation())
                .type(projectEntity.getType())
                .dateCreated(projectEntity.getDateCreated())
                .build();


    }

    public OutputDTOProjectImage createOutputDTOProjectImage(ProjectImageEntity projectImageEntity) {

        return OutputDTOProjectImage.builder()

                .id(projectImageEntity.getId())
                .projectId(projectImageEntity.getProject().getId())
                .imageURL(projectImageEntity.getImageUrl())
                .imageOrder(projectImageEntity.getImageOrder())
                .build();
    }



}

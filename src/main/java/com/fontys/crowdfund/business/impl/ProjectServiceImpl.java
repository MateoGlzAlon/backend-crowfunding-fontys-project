package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.persistence.ProjectImagesRepository;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProjectImage;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.ProjectImageEntity;
import com.fontys.crowdfund.persistence.specialdto.ProjectOnlyCoverLandingPage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProject;

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
            //CHECK : Ensure projectEntity is not null before converting it to OutputDTOProject.
            outputDTOProjects.add(createOutputDTOProject(projectEntity));
        }

        return outputDTOProjects;

    }

    // Get project by ID
    public OutputDTOProject getProjectById(int id) {
        //CHECK : Handle the case where the project with the given ID does not exist. Currently, Objects.requireNonNull() may throw a NullPointerException.
        return createOutputDTOProject(Objects.requireNonNull(projectRepository.findById(id).orElse(null)));
    }

    // Create a new project and link it to a user by userId
    public OutputDTOProject createProject(InputDTOProject postDTOProject) {

        //CHECK : Validate postDTOProject fields like name, description, location, and fundingGoal for null or invalid values.
        ProjectEntity project = ProjectEntity.builder()
                .name(postDTOProject.getName())
                .description(postDTOProject.getDescription())
                .location(postDTOProject.getLocation())
                .type(postDTOProject.getType())
                .dateCreated(postDTOProject.getDateCreated())
                .moneyRaised(0f) //CHECK : Confirm that moneyRaised should always start at 0f.
                .fundingGoal(postDTOProject.getFundingGoal())
                .user(userRepository.findByEmail(postDTOProject.getUserEmail())) //CHECK : Validate that the user exists in the database before assigning it to the project.
                .build();

        //CHECK : Ensure the projectRepository.save() operation succeeds without exceptions.
        return createOutputDTOProject(projectRepository.save(project));
    }

    @Override
    public void deleteProject(int id) {
        //CHECK : Handle cases where the project ID does not exist before attempting to delete.
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectOnlyCoverLandingPage> getCloseToFundingAllProjects() {

        List<ProjectOnlyCoverLandingPage> closeProjects = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.getCloseToFundingProjects()) {
            //CHECK : Ensure projectEntity and the associated image data are not null.
            ProjectOnlyCoverLandingPage projectClose = ProjectOnlyCoverLandingPage.builder()
                    .id(projectEntity.getId())
                    .imageCover(projectImagesRepository.getProjectImageCover(projectEntity.getId())) //CHECK : Validate that the imageCover is not null.
                    .name(projectEntity.getName())
                    .moneyRaised(projectEntity.getMoneyRaised())
                    .fundingGoal(projectEntity.getFundingGoal())
                    .dateCreated(projectEntity.getDateCreated())
                    .build();

            closeProjects.add(projectClose);
        }

        return closeProjects;

    }

    @Override
    public List<ProjectOnlyCoverLandingPage> getNewProjects() {

        List<ProjectOnlyCoverLandingPage> newProjects = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.getNewProjects()) {
            //CHECK : Validate projectEntity and its image data.
            ProjectOnlyCoverLandingPage projectNew = ProjectOnlyCoverLandingPage.builder()
                    .id(projectEntity.getId())
                    .imageCover(projectImagesRepository.getProjectImageCover(projectEntity.getId())) //CHECK : Ensure imageCover is not null.
                    .name(projectEntity.getName())
                    .moneyRaised(projectEntity.getMoneyRaised())
                    .fundingGoal(projectEntity.getFundingGoal())
                    .dateCreated(projectEntity.getDateCreated())
                    .build();

            newProjects.add(projectNew);
        }

        return newProjects;
    }

    @Override
    public List<OutputDTOProjectImage> getAllProjectImages() {

        List<OutputDTOProjectImage> outputDTOProjectImages = new ArrayList<>();

        for (ProjectImageEntity projectImageEntity : projectImagesRepository.findAll()) {
            //CHECK : Ensure projectImageEntity is not null before converting.
            outputDTOProjectImages.add(createOutputDTOProjectImage(projectImageEntity));
        }

        return outputDTOProjectImages;
    }

    @Override
    public OutputDTOProjectImage createProjectImage(InputDTOProjectImage projectDTOImage) {
        //CHECK : Validate projectDTOImage fields, such as imageURL and projectId, for null or invalid values.

        ProjectImageEntity projectImage = ProjectImageEntity.builder()
                .project(projectRepository.findById(projectDTOImage.getProjectId()).orElse(null)) //CHECK : Ensure the project exists before assigning it to the image.
                .imageUrl(projectDTOImage.getImageURL())
                .imageOrder(projectDTOImage.getImageOrder())
                .build();

        //CHECK : Ensure save operation does not fail or throw an exception.
        return createOutputDTOProjectImage(projectImagesRepository.save(projectImage));
    }

    @Override
    public OutputDTOProjectImage getProjectImageById(int id) {
        //CHECK : Handle cases where the image ID does not exist. Currently, Objects.requireNonNull() may throw a NullPointerException.
        return createOutputDTOProjectImage(Objects.requireNonNull(projectImagesRepository.findById(id).orElse(null)));
    }

    @Override
    public void deleteProjectImage(int id) {
        //CHECK : Validate that the project image ID exists before attempting to delete.
        projectImagesRepository.deleteById(id);
    }

    @Override
    public List<OutputDTOProject> getProjectsFromUserId(int id) {
        List<OutputDTOProject> outputDTOProject = new ArrayList<>();

        for (ProjectEntity projectEntity : projectRepository.findProjectsByUserId(id)) {
            //CHECK : Ensure projectEntity is not null before converting to OutputDTOProject.
            outputDTOProject.add(createOutputDTOProject(projectEntity));
        }

        return outputDTOProject;
    }

    @Override
    public Page<ProjectOnlyCoverLandingPage> getAllProjectsForLandingPage(
            String type,
            Double minPercentageFunded,
            Double maxPercentageFunded,
            String sortBy,
            int page,
            int size) {

        Pageable pageable = null;

        String dateCreatedString = "dateCreated";

        //CHECK : Validate the "sortBy" parameter to ensure it matches allowed values.
        switch(sortBy){
            case "dateCreatedDesc":
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, dateCreatedString));
                break;

            case "dateCreatedAsc":
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, dateCreatedString));
                break;

            case "percentageFundedDesc":
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "percentageFunded"));
                break;

            case "percentageFundedAsc":
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "percentageFunded"));
                break;

            default:
                pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, dateCreatedString));
                break;
        }


        // Fetch paginated data from the repository
        Page<ProjectEntity> projectEntitiesPage = projectRepository.getAllProjectsWithFiltersAndPagination(
                type, minPercentageFunded, maxPercentageFunded, pageable);

        //CHECK : Ensure projectEntitiesPage is not null before processing.
        // Transform each ProjectEntity into ProjectOnlyCoverLandingPage using Page.map()
        return projectEntitiesPage.map(projectEntity ->
                new ProjectOnlyCoverLandingPage(
                        projectEntity.getId(),
                        projectEntity.getName(),
                        projectImagesRepository.getImagesFromProjectId(projectEntity.getId()).get(0), //CHECK : Handle cases where no image is available for the project.
                        projectEntity.getMoneyRaised(),
                        projectEntity.getFundingGoal(),
                        projectEntity.getDateCreated(),
                        projectEntity.getDescription()
                )
        );
    }

    public OutputDTOProject createOutputDTOProject(ProjectEntity projectEntity) {
        //CHECK : Ensure projectEntity is not null to avoid NullPointerException.
        return OutputDTOProject.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .userEmail(projectEntity.getUser().getEmail()) //CHECK : Ensure user is not null and has an email.
                .fundingGoal(projectEntity.getFundingGoal())
                .moneyRaised(projectEntity.getMoneyRaised())
                .images(projectImagesRepository.getImagesFromProjectId(projectEntity.getId())) //CHECK : Ensure images list is not null or empty.
                .description(projectEntity.getDescription())
                .location(projectEntity.getLocation())
                .type(projectEntity.getType())
                .dateCreated(projectEntity.getDateCreated())
                .build();
    }

    public OutputDTOProjectImage createOutputDTOProjectImage(ProjectImageEntity projectImageEntity) {
        //CHECK : Ensure projectImageEntity is not null to avoid NullPointerException.
        return OutputDTOProjectImage.builder()
                .id(projectImageEntity.getId())
                .projectId(projectImageEntity.getProject().getId()) //CHECK : Ensure project is not null before accessing its ID.
                .imageURL(projectImageEntity.getImageUrl())
                .imageOrder(projectImageEntity.getImageOrder())
                .build();
    }
}

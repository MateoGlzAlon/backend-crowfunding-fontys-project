package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProjectImage;
import com.fontys.crowdfund.persistence.specialdto.ProjectOnlyCoverLandingPage;

import java.util.List;

public interface ProjectService {

    // Get all projects and convert them to DTOs
    List<OutputDTOProject> getAllProjects();

    // Get project by ID
    OutputDTOProject getProjectById(int id);

    // Create a new project and link it to a user by userId
    OutputDTOProject createProject(InputDTOProject projectDTO);

    void deleteProject(int id);

    List<ProjectOnlyCoverLandingPage> getCloseToFundingAllProjects();

    List<ProjectOnlyCoverLandingPage> getNewProjects();

    List<OutputDTOProjectImage> getAllProjectImages();

    OutputDTOProjectImage createProjectImage(InputDTOProjectImage projectDTOImage);

    OutputDTOProjectImage getProjectImageById(int id);

    void deleteProjectImage(int id);

    List<OutputDTOProject> getProjectsFromUserId(int id);

    public List<ProjectOnlyCoverLandingPage> getAllProjectsForLandingPage(String type, Double minPercentageFunded,
                                                                          Double maxPercentageFunded, String sortBy,
                                                                          int page, int size);
}

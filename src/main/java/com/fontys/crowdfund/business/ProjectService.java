package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProjectImage;

import java.util.List;

public interface ProjectService {

    // Get all projects and convert them to DTOs
    List<OutputDTOProject> getAllProjects();

    // Get project by ID
    OutputDTOProject getProjectById(int id);

    // Create a new project and link it to a user by userId
    OutputDTOProject createProject(InputDTOProject projectDTO);

    void deleteProject(int id);

    List<OutputDTOProject> getCloseToFundingAllProjects();

    List<OutputDTOProject> getNewProjects();

    List<OutputDTOProjectImage> getAllProjectImages();

    OutputDTOProjectImage createProjectImage(InputDTOProjectImage projectDTOImage);

    OutputDTOProjectImage getProjectImageById(int id);

    void deleteProjectImage(int id);

    List<OutputDTOProject> getProjectsFromUserId(int id);
}

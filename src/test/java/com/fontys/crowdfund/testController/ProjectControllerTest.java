package com.fontys.crowdfund.testController;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.controller.impl.ProjectControllerImpl;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOProjectImage;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProject;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOProjectImage;
import com.fontys.crowdfund.persistence.specialdto.ProjectOnlyCoverLandingPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProjectControllerTest {

    @InjectMocks
    private ProjectControllerImpl projectController;

    @Mock
    private ProjectService projectService;

    private OutputDTOProject testProject;
    private OutputDTOProjectImage testProjectImage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testProject = OutputDTOProject.builder()
                .id(1)
                .name("Test Project")
                .description("Test Description")
                .location("Test Location")
                .type("Test Type")
                .fundingGoal(1000.0F)
                .moneyRaised(500.0F)
                .images(Arrays.asList("image1.jpg", "image2.jpg"))
                .build();

        testProjectImage = OutputDTOProjectImage.builder()
                .id(1)
                .projectId(1)
                .imageURL("image1.jpg")
                .imageOrder(1)
                .build();
    }

    @Test
    void testGetAllProjects() {
        // Arrange
        when(projectService.getAllProjects()).thenReturn(Arrays.asList(testProject));

        // Act
        ResponseEntity<List<OutputDTOProject>> response = projectController.getAllProjects();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Test Project", response.getBody().get(0).getName());
        verify(projectService, times(1)).getAllProjects();
    }

    @Test
    void testGetProjectById() {
        // Arrange
        when(projectService.getProjectById(1)).thenReturn(testProject);

        // Act
        ResponseEntity<OutputDTOProject> response = projectController.getProjectById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test Project", response.getBody().getName());
        verify(projectService, times(1)).getProjectById(1);
    }

    @Test
    void testCreateProject() {

        List <String> images = null;
        // Arrange
        InputDTOProject inputDTOProject = new InputDTOProject(
                "Test Project", "Test Description", "Test Location",
                "Test Type", new Date(), 1000.0F, "test@user.com", images);
        when(projectService.createProject(inputDTOProject)).thenReturn(testProject);

        // Act
        ResponseEntity<OutputDTOProject> response = projectController.createProject(inputDTOProject);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Test Project", response.getBody().getName());
        verify(projectService, times(1)).createProject(inputDTOProject);
    }

    @Test
    void testDeleteProject() {
        // Arrange
        doNothing().when(projectService).deleteProject(1);

        // Act
        ResponseEntity<OutputDTOProject> response = projectController.deleteProject(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(projectService, times(1)).deleteProject(1);
    }

    @Test
    void testGetCloseToFundingProjects() {
        // Arrange
        ProjectOnlyCoverLandingPage projectCover = new ProjectOnlyCoverLandingPage(1, "Test Project", "image1.jpg", 500.0F, 1000.0F, null, "Description");
        when(projectService.getCloseToFundingAllProjects()).thenReturn(Arrays.asList(projectCover));

        // Act
        ResponseEntity<List<ProjectOnlyCoverLandingPage>> response = projectController.getCloseToFundingProjects();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Test Project", response.getBody().get(0).getName());
        verify(projectService, times(1)).getCloseToFundingAllProjects();
    }

    @Test
    void testGetNewProjects() {
        // Arrange
        ProjectOnlyCoverLandingPage projectCover = new ProjectOnlyCoverLandingPage(1, "New Project", "image2.jpg", 100.0F, 500.0F, null, "Description");
        when(projectService.getNewProjects()).thenReturn(Arrays.asList(projectCover));

        // Act
        ResponseEntity<List<ProjectOnlyCoverLandingPage>> response = projectController.getNewProjects();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("New Project", response.getBody().get(0).getName());
        verify(projectService, times(1)).getNewProjects();
    }

    @Test
    void testGetAllProjectsForLandingPage() {
        // Arrange
        when(projectService.getAllProjectsForLandingPage(null, null, null, "dateCreated", 0, 6))
                .thenReturn(Page.empty());

        // Act
        ResponseEntity<Map<String, Object>> response = projectController.getAllProjectsForLandingPage(null, null, null, "dateCreated", 0, 6);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, ((List<?>) response.getBody().get("content")).size());
        verify(projectService, times(1)).getAllProjectsForLandingPage(null, null, null, "dateCreated", 0, 6);
    }

    @Test
    void testGetProjectsFromUserId() {
        // Arrange
        when(projectService.getProjectsFromUserId(1)).thenReturn(Arrays.asList(testProject));

        // Act
        ResponseEntity<List<OutputDTOProject>> response = projectController.getProjectsFromUserID(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Test Project", response.getBody().get(0).getName());
        verify(projectService, times(1)).getProjectsFromUserId(1);
    }

    @Test
    void testGetAllProjectImages() {
        // Arrange
        when(projectService.getAllProjectImages()).thenReturn(Arrays.asList(testProjectImage));

        // Act
        ResponseEntity<List<OutputDTOProjectImage>> response = projectController.getAllProjectImages();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("image1.jpg", response.getBody().get(0).getImageURL());
        verify(projectService, times(1)).getAllProjectImages();
    }

    @Test
    void testCreateProjectImage() {
        // Arrange
        InputDTOProjectImage inputDTOProjectImage = new InputDTOProjectImage(1, "image1.jpg", 1);
        when(projectService.createProjectImage(inputDTOProjectImage)).thenReturn(testProjectImage);

        // Act
        ResponseEntity<OutputDTOProjectImage> response = projectController.createProjectImage(inputDTOProjectImage);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("image1.jpg", response.getBody().getImageURL());
        verify(projectService, times(1)).createProjectImage(inputDTOProjectImage);
    }

    @Test
    void testGetProjectImageById() {
        // Arrange
        when(projectService.getProjectImageById(1)).thenReturn(testProjectImage);

        // Act
        ResponseEntity<OutputDTOProjectImage> response = projectController.getProjectImageById(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("image1.jpg", response.getBody().getImageURL());
        verify(projectService, times(1)).getProjectImageById(1);
    }

    @Test
    void testDeleteProjectImage() {
        // Arrange
        doNothing().when(projectService).deleteProjectImage(1);

        // Act
        ResponseEntity<OutputDTOProjectImage> response = projectController.deleteProjectImage(1);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(projectService, times(1)).deleteProjectImage(1);
    }
}
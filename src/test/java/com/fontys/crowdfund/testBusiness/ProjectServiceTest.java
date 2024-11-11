package com.fontys.crowdfund.testBusiness;

import com.fontys.crowdfund.business.impl.ProjectServiceImpl;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.ProjectImagesRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.InputDTOProject;
import com.fontys.crowdfund.persistence.dto.OutputDTOProject;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectImagesRepository projectImageRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private static ProjectEntity project1;
    private static ProjectEntity project2;
    private static UserEntity user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = UserEntity.builder()
                .id(1)
                .email("user@example.com")
                .name("User Name")
                .password("password")
                .build();

        project1 = ProjectEntity.builder()
                .id(1)
                .name("Project One")
                .description("Description of project one")
                .location("Location One")
                .type("Type One")
                .dateCreated(new Date())
                .user(user)
                .fundingGoal(1000f)
                .moneyRaised(100f)
                .build();

        project2 = ProjectEntity.builder()
                .id(2)
                .name("Project Two")
                .description("Description of project two")
                .location("Location Two")
                .type("Type Two")
                .dateCreated(new Date())
                .user(user)
                .fundingGoal(2000f)
                .moneyRaised(500f)
                .build();
    }

    @Test
    @DisplayName("Should get all projects")
    void get_all_projects() {
        // Arrange
        when(projectRepository.findAll()).thenReturn(List.of(project1, project2));

        // Act
        List<OutputDTOProject> projects = projectService.getAllProjects();

        // Assert
        assertEquals(2, projects.size());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should add project and return output DTO")
    void add_project() {
        // Arrange
        InputDTOProject inputProject = new InputDTOProject();
        inputProject.setName("New Project");
        inputProject.setDescription("New project description");
        inputProject.setLocation("New Location");
        inputProject.setType("New Type");
        inputProject.setFundingGoal(3000f);

        ProjectEntity savedProject = ProjectEntity.builder()
                .id(3)
                .name("New Project")
                .description("New project description")
                .location("New Location")
                .type("New Type")
                .dateCreated(new Date())
                .user(user)
                .fundingGoal(3000f)
                .moneyRaised(0f)
                .build();

        when(projectRepository.save(any(ProjectEntity.class))).thenReturn(savedProject);

        // Act
        OutputDTOProject result = projectService.createProject(inputProject);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.getId());
        assertEquals("New Project", result.getName());
        verify(projectRepository, times(1)).save(any(ProjectEntity.class));
    }

    @Test
    @DisplayName("Should get project by ID")
    void get_project_by_id() {
        // Arrange
        when(projectRepository.findById(1)).thenReturn(Optional.of(project1));

        // Act
        OutputDTOProject project = projectService.getProjectById(1);

        // Assert
        assertNotNull(project);
        assertEquals(1, project.getId());
        assertEquals("Project One", project.getName());
        verify(projectRepository, times(1)).findById(1);
    }

    @Test
    @DisplayName("Should delete project by ID")
    void delete_project_by_id() {
        // Arrange
        when(projectRepository.findById(1)).thenReturn(Optional.of(project1));
        doNothing().when(projectRepository).deleteById(1);

        // Act
        projectService.deleteProject(1);

        // Assert
        verify(projectRepository, times(1)).deleteById(1);
    }



    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should throw exception if project to delete not found")
    void delete_project_by_id_not_found() {
        // Arrange
        when(projectRepository.findById(99)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> projectService.deleteProject(99));
        assertEquals("Project not found", thrown.getMessage());
        verify(projectRepository, times(1)).findById(99);
        verify(projectRepository, never()).deleteById(99);
    }


    //TO-DO
    @Disabled
    @Test
    @DisplayName("Should throw exception if project not found by ID")
    void get_project_by_id_not_found() {
        // Arrange
        when(projectRepository.findById(99)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> projectService.getProjectById(99));
        assertEquals("Project not found", thrown.getMessage());
        verify(projectRepository, times(1)).findById(99);
    }

    @Test
    @DisplayName("Should get all projects close to funding goal")
    void get_close_to_funding_all_projects() {
        // Arrange
        ProjectEntity project3 = ProjectEntity.builder()
                .id(3)
                .name("Project Three")
                .description("Description of project three")
                .location("Location Three")
                .type("Type Three")
                .dateCreated(new Date())
                .user(user)
                .fundingGoal(1000f)
                .moneyRaised(950f) // Close to funding goal
                .build();

        when(projectRepository.getCloseToFundingProjects()).thenReturn(List.of(project3));

        // Act
        List<OutputDTOProject> projects = projectService.getCloseToFundingAllProjects();

        // Assert
        assertEquals(1, projects.size());
        assertEquals("Project Three", projects.get(0).getName());
        assertEquals(3, projects.get(0).getId());
        verify(projectRepository, times(1)).getCloseToFundingProjects();
    }


    @Test
    @DisplayName("Should get all projects close to funding goal")
    void get_new_all_projects() {
        // Arrange
        ProjectEntity project3 = ProjectEntity.builder()
                .id(3)
                .name("Project Three")
                .description("Description of project three")
                .location("Location Three")
                .type("Type Three")
                .dateCreated(new Date())
                .user(user)
                .fundingGoal(1000f)
                .moneyRaised(950f) // Close to funding goal
                .build();

        when(projectRepository.getNewProjects()).thenReturn(List.of(project3));

        // Act
        List<OutputDTOProject> projects = projectService.getNewProjects();

        // Assert
        assertEquals(1, projects.size());
        assertEquals("Project Three", projects.get(0).getName());
        assertEquals(3, projects.get(0).getId());
        verify(projectRepository, times(1)).getNewProjects();
    }
}

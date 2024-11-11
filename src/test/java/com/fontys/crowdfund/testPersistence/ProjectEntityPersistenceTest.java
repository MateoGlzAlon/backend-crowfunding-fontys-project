package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectEntityPersistenceTest {

    private ProjectEntity testProject;
    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        // Create a UserEntity object
        testUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .build();

        // Initialize testProject
        testProject = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(new Date())
                .user(testUser)
                .fundingGoal(10000.0f)
                .moneyRaised(500.0f)
                .build();
    }

    @Test
    void testProjectNotNull() {
        // Check if testProject is not null
        assertNotNull(testProject, "Test project should not be null");
    }

    @Test
    void testProjectId() {
        // Check if project ID is as expected
        assertEquals(1, testProject.getId(), "Project ID should be 1");
    }

    @Test
    void testProjectName() {
        // Check if the project name is as expected
        assertNotNull(testProject.getName(), "Project name should not be null");
        assertEquals("Test Project", testProject.getName(), "Project name should be 'Test Project'");
    }

    @Test
    void testProjectDescription() {
        // Check if the project description is as expected
        assertNotNull(testProject.getDescription(), "Project description should not be null");
        assertEquals("This is a test project.", testProject.getDescription(), "Project description should match");
    }

    @Test
    void testProjectLocation() {
        // Check if the project location is as expected
        assertEquals("Test Location", testProject.getLocation(), "Project location should be 'Test Location'");
    }

    @Test
    void testProjectType() {
        // Check if the project type is as expected
        assertEquals("Tech", testProject.getType(), "Project type should be 'Tech'");
    }

    @Test
    void testProjectDateCreated() {
        // Check if dateCreated is not null and set correctly
        assertNotNull(testProject.getDateCreated(), "Project dateCreated should not be null");
        assertTrue(testProject.getDateCreated().before(new Date()) || testProject.getDateCreated().equals(new Date()), "Project dateCreated should be today or earlier");
    }

    @Test
    void testProjectUser() {
        // Check if user is set correctly
        assertNotNull(testProject.getUser(), "User should not be null");
        assertEquals(testUser, testProject.getUser(), "User should match the testUser");
    }

    @Test
    void testFundingGoal() {
        // Check if funding goal is set correctly
        assertNotNull(testProject.getFundingGoal(), "Funding goal should not be null");
        assertEquals(10000.0f, testProject.getFundingGoal(), "Funding goal should be 10000.0");
    }

    @Test
    void testMoneyRaised() {
        // Check if money raised is set correctly
        assertNotNull(testProject.getMoneyRaised(), "Money raised should not be null");
        assertEquals(500.0f, testProject.getMoneyRaised(), "Money raised should be 500.0");
    }
}

package com.fontys.crowdfund.testPersistence.Entity;

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

    // Group 1: Initialization Tests
    @Test
    void testProjectNotNull() {
        // Check if testProject is not null
        assertNotNull(testProject, "Test project should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that a ProjectEntity can be created using no-args constructor
        ProjectEntity project = new ProjectEntity();
        assertNotNull(project, "ProjectEntity created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that a ProjectEntity can be created with all args constructor
        ProjectEntity project = new ProjectEntity(2, "Project Name", "Description", "Location", "Tech", new Date(), testUser, 5000.0f, 200.0f);
        assertNotNull(project, "ProjectEntity created with all-args constructor should not be null");
        assertEquals(2, project.getId(), "Project ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that a ProjectEntity can be created using the builder
        ProjectEntity project = ProjectEntity.builder()
                .id(3)
                .name("Another Project")
                .description("Another Description")
                .location("Another Location")
                .type("Health")
                .dateCreated(new Date())
                .user(testUser)
                .fundingGoal(15000.0f)
                .moneyRaised(300.0f)
                .build();

        assertNotNull(project, "ProjectEntity created with builder should not be null");
        assertEquals("Another Project", project.getName(), "Project name should be 'Another Project'");
    }

    // Group 2: Getter Tests
    @Test
    void testProjectId() {
        // Check if project ID is as expected
        assertEquals(1, testProject.getId(), "Project ID should be 1");
    }

    @Test
    void testProjectName() {
        // Check if project name is as expected
        assertEquals("Test Project", testProject.getName(), "Project name should be 'Test Project'");
    }

    @Test
    void testProjectDescription() {
        // Check if project description is as expected
        assertEquals("This is a test project.", testProject.getDescription(), "Project description should match");
    }

    @Test
    void testProjectLocation() {
        // Check if project location is as expected
        assertEquals("Test Location", testProject.getLocation(), "Project location should be 'Test Location'");
    }

    @Test
    void testProjectType() {
        // Check if project type is as expected
        assertEquals("Tech", testProject.getType(), "Project type should be 'Tech'");
    }

    @Test
    void testProjectDateCreated() {
        // Check if dateCreated is not null and set correctly
        assertNotNull(testProject.getDateCreated(), "Project dateCreated should not be null");
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
        assertEquals(10000.0f, testProject.getFundingGoal(), "Funding goal should be 10000.0");
    }

    @Test
    void testMoneyRaised() {
        // Check if money raised is set correctly
        assertEquals(500.0f, testProject.getMoneyRaised(), "Money raised should be 500.0");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new ID
        testProject.setId(2);
        assertEquals(2, testProject.getId(), "Project ID should be 2");
    }

    @Test
    void testSetName() {
        // Set a new name
        testProject.setName("Updated Project Name");
        assertEquals("Updated Project Name", testProject.getName(), "Project name should be 'Updated Project Name'");
    }

    @Test
    void testSetDescription() {
        // Set a new description
        testProject.setDescription("Updated Description");
        assertEquals("Updated Description", testProject.getDescription(), "Project description should be 'Updated Description'");
    }

    @Test
    void testSetLocation() {
        // Set a new location
        testProject.setLocation("Updated Location");
        assertEquals("Updated Location", testProject.getLocation(), "Project location should be 'Updated Location'");
    }

    @Test
    void testSetType() {
        // Set a new type
        testProject.setType("Updated Type");
        assertEquals("Updated Type", testProject.getType(), "Project type should be 'Updated Type'");
    }

    @Test
    void testSetDateCreated() {
        // Set a new dateCreated
        Date newDate = new Date();
        testProject.setDateCreated(newDate);
        assertEquals(newDate, testProject.getDateCreated(), "Project dateCreated should match the new date");
    }

    @Test
    void testSetUser() {
        // Set a new user
        UserEntity newUser = UserEntity.builder()
                .id(2)
                .email("newuser@email.com")
                .name("new user")
                .password("newpassword")
                .build();
        testProject.setUser(newUser);
        assertEquals(newUser, testProject.getUser(), "User should match the new user");
    }

    @Test
    void testSetFundingGoal() {
        // Set a new funding goal
        testProject.setFundingGoal(15000.0f);
        assertEquals(15000.0f, testProject.getFundingGoal(), "Funding goal should be 15000.0");
    }

    @Test
    void testSetMoneyRaised() {
        // Set a new money raised value
        testProject.setMoneyRaised(800.0f);
        assertEquals(800.0f, testProject.getMoneyRaised(), "Money raised should be 800.0");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another project with the same values
        ProjectEntity projectToCompare = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testProject.getDateCreated())
                .user(testUser)
                .fundingGoal(10000.0f)
                .moneyRaised(500.0f)
                .build();

        assertEquals(testProject, projectToCompare, "Projects should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another project with different values
        ProjectEntity projectToCompare = ProjectEntity.builder()
                .id(2)
                .name("Different Project")
                .description("Different description")
                .location("Different Location")
                .type("Non-Tech")
                .dateCreated(new Date())
                .user(testUser)
                .fundingGoal(20000.0f)
                .moneyRaised(1000.0f)
                .build();

        assertNotEquals(testProject, projectToCompare, "Projects should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another project with the same values
        ProjectEntity projectToCompare = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testProject.getDateCreated())
                .user(testUser)
                .fundingGoal(10000.0f)
                .moneyRaised(500.0f)
                .build();

        assertEquals(testProject.hashCode(), projectToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "ProjectEntity(id=1, name=Test Project, description=This is a test project., location=Test Location, type=Tech, dateCreated=" + testProject.getDateCreated() + ", user=" + testUser + ", fundingGoal=10000.0, moneyRaised=500.0)";
        assertEquals(expected, testProject.toString(), "toString method should return the expected output");
    }
}

package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OutputDTOProjectTest {

    private OutputDTOProject testProjectDTO;
    private Date testDate;
    private List<String> testImages;

    @BeforeEach
    void setUp() {
        // Set up test data
        testDate = new Date();
        testImages = Arrays.asList("http://example.com/image1.jpg", "http://example.com/image2.jpg");

        // Initialize testProjectDTO
        testProjectDTO = OutputDTOProject.builder()
                .id(1)
                .name("Test Project")
                .userEmail("user@example.com")
                .fundingGoal(10000.0f)
                .moneyRaised(5000.0f)
                .images(testImages)
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testProjectDTONotNull() {
        // Check if testProjectDTO is not null
        assertNotNull(testProjectDTO, "Test ProjectDTO should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that an OutputDTOProject can be created using no-args constructor
        OutputDTOProject projectDTO = new OutputDTOProject();
        assertNotNull(projectDTO, "OutputDTOProject created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an OutputDTOProject can be created with all args constructor
        OutputDTOProject projectDTO = new OutputDTOProject(
                2,
                "Another Project",
                "anotheruser@example.com",
                15000.0f,
                7500.0f,
                testImages,
                "Another description",
                "Another Location",
                "Health",
                testDate
        );
        assertNotNull(projectDTO, "OutputDTOProject created with all-args constructor should not be null");
        assertEquals(2, projectDTO.getId(), "Project ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that an OutputDTOProject can be created using the builder
        OutputDTOProject projectDTO = OutputDTOProject.builder()
                .id(3)
                .name("Builder Project")
                .userEmail("builderuser@example.com")
                .fundingGoal(20000.0f)
                .moneyRaised(10000.0f)
                .images(testImages)
                .description("Builder description")
                .location("Builder Location")
                .type("Tech")
                .dateCreated(testDate)
                .build();

        assertNotNull(projectDTO, "OutputDTOProject created with builder should not be null");
        assertEquals("Builder Project", projectDTO.getName(), "Project name should be 'Builder Project'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetId() {
        // Check if the project ID is as expected
        assertEquals(1, testProjectDTO.getId(), "Project ID should be 1");
    }

    @Test
    void testGetName() {
        // Check if the project name is as expected
        assertEquals("Test Project", testProjectDTO.getName(), "Project name should be 'Test Project'");
    }

    @Test
    void testGetUserEmail() {
        // Check if the user email is as expected
        assertEquals("user@example.com", testProjectDTO.getUserEmail(), "User email should be 'user@example.com'");
    }

    @Test
    void testGetFundingGoal() {
        // Check if the funding goal is as expected
        assertEquals(10000.0f, testProjectDTO.getFundingGoal(), "Funding goal should be 10000.0");
    }

    @Test
    void testGetMoneyRaised() {
        // Check if the money raised is as expected
        assertEquals(5000.0f, testProjectDTO.getMoneyRaised(), "Money raised should be 5000.0");
    }

    @Test
    void testGetImages() {
        // Check if the images list is as expected
        assertEquals(testImages, testProjectDTO.getImages(), "Images list should match the testImages list");
    }

    @Test
    void testGetDescription() {
        // Check if the description is as expected
        assertEquals("This is a test project.", testProjectDTO.getDescription(), "Project description should match");
    }

    @Test
    void testGetLocation() {
        // Check if the location is as expected
        assertEquals("Test Location", testProjectDTO.getLocation(), "Project location should be 'Test Location'");
    }

    @Test
    void testGetType() {
        // Check if the project type is as expected
        assertEquals("Tech", testProjectDTO.getType(), "Project type should be 'Tech'");
    }

    @Test
    void testGetDateCreated() {
        // Check if the date created is as expected
        assertEquals(testDate, testProjectDTO.getDateCreated(), "Date created should match the testDate");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new project ID
        testProjectDTO.setId(2);
        assertEquals(2, testProjectDTO.getId(), "Project ID should be 2");
    }

    @Test
    void testSetName() {
        // Set a new project name
        testProjectDTO.setName("Updated Project");
        assertEquals("Updated Project", testProjectDTO.getName(), "Project name should be 'Updated Project'");
    }

    @Test
    void testSetUserEmail() {
        // Set a new user email
        testProjectDTO.setUserEmail("newuser@example.com");
        assertEquals("newuser@example.com", testProjectDTO.getUserEmail(), "User email should be 'newuser@example.com'");
    }

    @Test
    void testSetFundingGoal() {
        // Set a new funding goal
        testProjectDTO.setFundingGoal(20000.0f);
        assertEquals(20000.0f, testProjectDTO.getFundingGoal(), "Funding goal should be 20000.0");
    }

    @Test
    void testSetMoneyRaised() {
        // Set a new money raised amount
        testProjectDTO.setMoneyRaised(10000.0f);
        assertEquals(10000.0f, testProjectDTO.getMoneyRaised(), "Money raised should be 10000.0");
    }

    @Test
    void testSetImages() {
        // Set a new images list
        List<String> newImages = Arrays.asList("http://example.com/newimage1.jpg", "http://example.com/newimage2.jpg");
        testProjectDTO.setImages(newImages);
        assertEquals(newImages, testProjectDTO.getImages(), "Images list should match the new images list");
    }

    @Test
    void testSetDescription() {
        // Set a new description
        testProjectDTO.setDescription("Updated Description");
        assertEquals("Updated Description", testProjectDTO.getDescription(), "Project description should be 'Updated Description'");
    }

    @Test
    void testSetLocation() {
        // Set a new location
        testProjectDTO.setLocation("Updated Location");
        assertEquals("Updated Location", testProjectDTO.getLocation(), "Project location should be 'Updated Location'");
    }

    @Test
    void testSetType() {
        // Set a new type
        testProjectDTO.setType("Updated Type");
        assertEquals("Updated Type", testProjectDTO.getType(), "Project type should be 'Updated Type'");
    }

    @Test
    void testSetDateCreated() {
        // Set a new date
        Date newDate = new Date();
        testProjectDTO.setDateCreated(newDate);
        assertEquals(newDate, testProjectDTO.getDateCreated(), "Date created should match the new date");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another ProjectDTO with the same values
        OutputDTOProject projectToCompare = OutputDTOProject.builder()
                .id(1)
                .name("Test Project")
                .userEmail("user@example.com")
                .fundingGoal(10000.0f)
                .moneyRaised(5000.0f)
                .images(testImages)
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .build();

        assertEquals(testProjectDTO, projectToCompare, "Project DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another ProjectDTO with different values
        OutputDTOProject projectToCompare = OutputDTOProject.builder()
                .id(2)
                .name("Different Project")
                .userEmail("differentuser@example.com")
                .fundingGoal(5000.0f)
                .moneyRaised(2500.0f)
                .images(Arrays.asList("http://example.com/differentimage.jpg"))
                .description("Different description")
                .location("Different Location")
                .type("Health")
                .dateCreated(new Date())
                .build();

        assertNotEquals(testProjectDTO, projectToCompare, "Project DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another ProjectDTO with the same values
        OutputDTOProject projectToCompare = OutputDTOProject.builder()
                .id(1)
                .name("Test Project")
                .userEmail("user@example.com")
                .fundingGoal(10000.0f)
                .moneyRaised(5000.0f)
                .images(testImages)
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .build();

        assertEquals(testProjectDTO.hashCode(), projectToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "OutputDTOProject(id=1, name=Test Project, userEmail=user@example.com, fundingGoal=10000.0, moneyRaised=5000.0, images=" + testImages + ", description=This is a test project., location=Test Location, type=Tech, dateCreated=" + testDate + ")";
        assertEquals(expected, testProjectDTO.toString(), "toString method should return the expected output");
    }
}

package com.fontys.crowdfund.testPersistence.InputDTO;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputDTOProjectTest {

    private InputDTOProject testProjectDTO;
    private Date testDate;
    private List<String> testImages;

    @BeforeEach
    void setUp() {
        // Set up test data
        testDate = new Date();
        testImages = Arrays.asList("http://example.com/image1.jpg", "http://example.com/image2.jpg");

        // Initialize testProjectDTO
        testProjectDTO = InputDTOProject.builder()
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .fundingGoal(10000.0f)
                .userEmail("user@example.com")
                .images(testImages)
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
        // Ensure that an InputDTOProject can be created using no-args constructor
        InputDTOProject projectDTO = new InputDTOProject();
        assertNotNull(projectDTO, "InputDTOProject created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an InputDTOProject can be created with all args constructor
        InputDTOProject projectDTO = new InputDTOProject(
                "Another Project",
                "Another description",
                "Another Location",
                "Health",
                testDate,
                15000.0f,
                "anotheruser@example.com",
                testImages
        );
        assertNotNull(projectDTO, "InputDTOProject created with all-args constructor should not be null");
        assertEquals("Another Project", projectDTO.getName(), "Project name should be 'Another Project'");
    }

    @Test
    void testBuilder() {
        // Ensure that an InputDTOProject can be created using the builder
        InputDTOProject projectDTO = InputDTOProject.builder()
                .name("Builder Project")
                .description("Builder description")
                .location("Builder Location")
                .type("Tech")
                .dateCreated(testDate)
                .fundingGoal(20000.0f)
                .userEmail("builderuser@example.com")
                .images(testImages)
                .build();

        assertNotNull(projectDTO, "InputDTOProject created with builder should not be null");
        assertEquals("Builder Project", projectDTO.getName(), "Project name should be 'Builder Project'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetName() {
        // Check if the name is as expected
        assertEquals("Test Project", testProjectDTO.getName(), "Project name should be 'Test Project'");
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
        // Check if the type is as expected
        assertEquals("Tech", testProjectDTO.getType(), "Project type should be 'Tech'");
    }

    @Test
    void testGetDateCreated() {
        // Check if the date created is as expected
        assertEquals(testDate, testProjectDTO.getDateCreated(), "Date created should match the testDate");
    }

    @Test
    void testGetFundingGoal() {
        // Check if the funding goal is as expected
        assertEquals(10000.0f, testProjectDTO.getFundingGoal(), "Funding goal should be 10000.0");
    }

    @Test
    void testGetUserEmail() {
        // Check if the user email is as expected
        assertEquals("user@example.com", testProjectDTO.getUserEmail(), "User email should be 'user@example.com'");
    }

    @Test
    void testGetImages() {
        // Check if the images are as expected
        assertEquals(testImages, testProjectDTO.getImages(), "Images list should match the testImages list");
    }

    // Group 3: Setter Tests
    @Test
    void testSetName() {
        // Set a new name
        testProjectDTO.setName("Updated Project Name");
        assertEquals("Updated Project Name", testProjectDTO.getName(), "Project name should be 'Updated Project Name'");
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

    @Test
    void testSetFundingGoal() {
        // Set a new funding goal
        testProjectDTO.setFundingGoal(20000.0f);
        assertEquals(20000.0f, testProjectDTO.getFundingGoal(), "Funding goal should be 20000.0");
    }

    @Test
    void testSetUserEmail() {
        // Set a new user email
        testProjectDTO.setUserEmail("newuser@example.com");
        assertEquals("newuser@example.com", testProjectDTO.getUserEmail(), "User email should be 'newuser@example.com'");
    }

    @Test
    void testSetImages() {
        // Set a new images list
        List<String> newImages = Arrays.asList("http://example.com/newimage1.jpg", "http://example.com/newimage2.jpg");
        testProjectDTO.setImages(newImages);
        assertEquals(newImages, testProjectDTO.getImages(), "Images list should match the new images list");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another project with the same values
        InputDTOProject projectToCompare = InputDTOProject.builder()
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .fundingGoal(10000.0f)
                .userEmail("user@example.com")
                .images(testImages)
                .build();

        assertEquals(testProjectDTO, projectToCompare, "Projects should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another project with different values
        InputDTOProject projectToCompare = InputDTOProject.builder()
                .name("Different Project")
                .description("Different description")
                .location("Different Location")
                .type("Health")
                .dateCreated(testDate)
                .fundingGoal(5000.0f)
                .userEmail("differentuser@example.com")
                .images(Arrays.asList("http://example.com/differentimage.jpg"))
                .build();

        assertNotEquals(testProjectDTO, projectToCompare, "Projects should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another project with the same values
        InputDTOProject projectToCompare = InputDTOProject.builder()
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(testDate)
                .fundingGoal(10000.0f)
                .userEmail("user@example.com")
                .images(testImages)
                .build();

        assertEquals(testProjectDTO.hashCode(), projectToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "InputDTOProject(name=Test Project, description=This is a test project., location=Test Location, type=Tech, dateCreated="
                + testDate + ", fundingGoal=10000.0, userEmail=user@example.com, images=" + testImages + ")";
        assertEquals(expected, testProjectDTO.toString(), "toString method should return the expected output");
    }
}

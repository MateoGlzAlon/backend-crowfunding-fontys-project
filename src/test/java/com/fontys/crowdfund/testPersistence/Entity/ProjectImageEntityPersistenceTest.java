package com.fontys.crowdfund.testPersistence.Entity;

import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.ProjectImageEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectImageEntityPersistenceTest {

    private ProjectImageEntity testImage;
    private ProjectEntity testProject;

    @BeforeEach
    void setUp() {
        // Create a ProjectEntity object
        testProject = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .description("This is a test project.")
                .location("Test Location")
                .type("Tech")
                .dateCreated(new java.util.Date())
                .fundingGoal(10000.0f)
                .moneyRaised(500.0f)
                .build();

        // Initialize ProjectImageEntity object
        testImage = ProjectImageEntity.builder()
                .id(1)
                .project(testProject)
                .imageUrl("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testProjectImageNotNull() {
        // Check if testImage is not null
        assertNotNull(testImage, "Test image should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that a ProjectImageEntity can be created using no-args constructor
        ProjectImageEntity image = new ProjectImageEntity();
        assertNotNull(image, "ProjectImageEntity created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that a ProjectImageEntity can be created with all args constructor
        ProjectImageEntity image = new ProjectImageEntity(2, testProject, "http://example.com/image2.jpg", 2);
        assertNotNull(image, "ProjectImageEntity created with all-args constructor should not be null");
        assertEquals(2, image.getId(), "Image ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that a ProjectImageEntity can be created using the builder
        ProjectImageEntity image = ProjectImageEntity.builder()
                .id(3)
                .project(testProject)
                .imageUrl("http://example.com/image3.jpg")
                .imageOrder(3)
                .build();

        assertNotNull(image, "ProjectImageEntity created with builder should not be null");
        assertEquals("http://example.com/image3.jpg", image.getImageUrl(), "Image URL should match 'http://example.com/image3.jpg'");
    }

    // Group 2: Getter Tests
    @Test
    void testProjectImageId() {
        // Check if the image ID is as expected
        assertEquals(1, testImage.getId(), "Image ID should be 1");
    }

    @Test
    void testProjectImageProject() {
        // Check if the project is set correctly
        assertEquals(testProject, testImage.getProject(), "Project should match the testProject");
    }

    @Test
    void testProjectImageUrl() {
        // Check if the image URL is set as expected
        assertEquals("http://example.com/image1.jpg", testImage.getImageUrl(), "Image URL should match 'http://example.com/image1.jpg'");
    }

    @Test
    void testProjectImageOrder() {
        // Check if the image order is set as expected
        assertEquals(1, testImage.getImageOrder(), "Image order should be 1");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new ID
        testImage.setId(2);
        assertEquals(2, testImage.getId(), "Image ID should be 2");
    }

    @Test
    void testSetProject() {
        // Set a new project
        ProjectEntity newProject = ProjectEntity.builder()
                .id(2)
                .name("New Project")
                .description("New project description")
                .location("New Location")
                .type("Health")
                .dateCreated(new java.util.Date())
                .fundingGoal(15000.0f)
                .moneyRaised(800.0f)
                .build();
        testImage.setProject(newProject);
        assertEquals(newProject, testImage.getProject(), "Project should match the new project");
    }

    @Test
    void testSetImageUrl() {
        // Set a new image URL
        testImage.setImageUrl("http://example.com/imageUpdated.jpg");
        assertEquals("http://example.com/imageUpdated.jpg", testImage.getImageUrl(), "Image URL should match 'http://example.com/imageUpdated.jpg'");
    }

    @Test
    void testSetImageOrder() {
        // Set a new image order
        testImage.setImageOrder(2);
        assertEquals(2, testImage.getImageOrder(), "Image order should be 2");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another image with the same values
        ProjectImageEntity imageToCompare = ProjectImageEntity.builder()
                .id(1)
                .project(testProject)
                .imageUrl("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();

        assertEquals(testImage, imageToCompare, "Images should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another image with different values
        ProjectImageEntity imageToCompare = ProjectImageEntity.builder()
                .id(2)
                .project(testProject)
                .imageUrl("http://example.com/image2.jpg")
                .imageOrder(2)
                .build();

        assertNotEquals(testImage, imageToCompare, "Images should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another image with the same values
        ProjectImageEntity imageToCompare = ProjectImageEntity.builder()
                .id(1)
                .project(testProject)
                .imageUrl("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();

        assertEquals(testImage.hashCode(), imageToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "ProjectImageEntity(id=1, project=" + testProject + ", imageUrl=http://example.com/image1.jpg, imageOrder=1)";
        assertEquals(expected, testImage.toString(), "toString method should return the expected output");
    }
}
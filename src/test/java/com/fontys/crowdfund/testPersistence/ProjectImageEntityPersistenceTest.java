package com.fontys.crowdfund.testPersistence;

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

    @Test
    void testProjectImageNotNull() {
        // Check if testImage is not null
        assertNotNull(testImage, "Test image should not be null");
    }

    @Test
    void testProjectImageId() {
        // Check if the image ID is as expected
        assertEquals(1, testImage.getId(), "Image ID should be 1");
    }

    @Test
    void testProjectImageProject() {
        // Check if the project is set correctly
        assertNotNull(testImage.getProject(), "Project should not be null");
        assertEquals(testProject, testImage.getProject(), "Project should match the testProject");
    }

    @Test
    void testProjectImageUrl() {
        // Check if the image URL is set as expected
        assertNotNull(testImage.getImageUrl(), "Image URL should not be null");
        assertEquals("http://example.com/image1.jpg", testImage.getImageUrl(), "Image URL should match 'http://example.com/image1.jpg'");
    }

    @Test
    void testProjectImageOrder() {
        // Check if the image order is set as expected
        assertNotNull(testImage.getImageOrder(), "Image order should not be null");
        assertEquals(1, testImage.getImageOrder(), "Image order should be 1");
    }
}

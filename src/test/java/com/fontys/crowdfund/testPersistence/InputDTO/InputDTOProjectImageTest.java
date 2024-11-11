package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.InputDTOProjectImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputDTOProjectImageTest {

    private InputDTOProjectImage testImageDTO;

    @BeforeEach
    void setUp() {
        // Initialize testImageDTO
        testImageDTO = InputDTOProjectImage.builder()
                .projectId(1)
                .imageURL("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testImageDTONotNull() {
        // Check if testImageDTO is not null
        assertNotNull(testImageDTO, "Test ImageDTO should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that an InputDTOProjectImage can be created using no-args constructor
        InputDTOProjectImage imageDTO = new InputDTOProjectImage();
        assertNotNull(imageDTO, "InputDTOProjectImage created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an InputDTOProjectImage can be created with all args constructor
        InputDTOProjectImage imageDTO = new InputDTOProjectImage(2, "http://example.com/image2.jpg", 2);
        assertNotNull(imageDTO, "InputDTOProjectImage created with all-args constructor should not be null");
        assertEquals(2, imageDTO.getProjectId(), "Project ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that an InputDTOProjectImage can be created using the builder
        InputDTOProjectImage imageDTO = InputDTOProjectImage.builder()
                .projectId(3)
                .imageURL("http://example.com/image3.jpg")
                .imageOrder(3)
                .build();

        assertNotNull(imageDTO, "InputDTOProjectImage created with builder should not be null");
        assertEquals("http://example.com/image3.jpg", imageDTO.getImageURL(), "Image URL should match 'http://example.com/image3.jpg'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetProjectId() {
        // Check if the project ID is as expected
        assertEquals(1, testImageDTO.getProjectId(), "Project ID should be 1");
    }

    @Test
    void testGetImageURL() {
        // Check if the image URL is as expected
        assertEquals("http://example.com/image1.jpg", testImageDTO.getImageURL(), "Image URL should be 'http://example.com/image1.jpg'");
    }

    @Test
    void testGetImageOrder() {
        // Check if the image order is as expected
        assertEquals(1, testImageDTO.getImageOrder(), "Image order should be 1");
    }

    // Group 3: Setter Tests
    @Test
    void testSetProjectId() {
        // Set a new project ID
        testImageDTO.setProjectId(2);
        assertEquals(2, testImageDTO.getProjectId(), "Project ID should be 2");
    }

    @Test
    void testSetImageURL() {
        // Set a new image URL
        testImageDTO.setImageURL("http://example.com/newimage.jpg");
        assertEquals("http://example.com/newimage.jpg", testImageDTO.getImageURL(), "Image URL should match 'http://example.com/newimage.jpg'");
    }

    @Test
    void testSetImageOrder() {
        // Set a new image order
        testImageDTO.setImageOrder(2);
        assertEquals(2, testImageDTO.getImageOrder(), "Image order should be 2");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another ImageDTO with the same values
        InputDTOProjectImage imageToCompare = InputDTOProjectImage.builder()
                .projectId(1)
                .imageURL("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();

        assertEquals(testImageDTO, imageToCompare, "Image DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another ImageDTO with different values
        InputDTOProjectImage imageToCompare = InputDTOProjectImage.builder()
                .projectId(2)
                .imageURL("http://example.com/image2.jpg")
                .imageOrder(2)
                .build();

        assertNotEquals(testImageDTO, imageToCompare, "Image DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another ImageDTO with the same values
        InputDTOProjectImage imageToCompare = InputDTOProjectImage.builder()
                .projectId(1)
                .imageURL("http://example.com/image1.jpg")
                .imageOrder(1)
                .build();

        assertEquals(testImageDTO.hashCode(), imageToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "InputDTOProjectImage(projectId=1, imageURL=http://example.com/image1.jpg, imageOrder=1)";
        assertEquals(expected, testImageDTO.toString(), "toString method should return the expected output");
    }
}

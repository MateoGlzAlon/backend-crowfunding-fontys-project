package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.entity.PaymentEntity;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentEntityPersistenceTest {

    private PaymentEntity testPayment;
    private UserEntity testUser;
    private ProjectEntity testProject;

    @BeforeEach
    void setUp() {
        // Create a UserEntity object
        testUser = UserEntity.builder()
                .id(1)
                .email("user@email.com")
                .name("user name")
                .password("user password")
                .build();

        // Create a ProjectEntity object
        testProject = ProjectEntity.builder()
                .id(1)
                .name("Test Project")
                .build();

        // Initialize testPayment
        testPayment = PaymentEntity.builder()
                .id(1)
                .user(testUser)
                .project(testProject)
                .amount(100.0f)
                .paymentDate(new Date())
                .build();
    }

    @Test
    void testPaymentNotNull() {
        // Check if testPayment is not null
        assertNotNull(testPayment, "Test payment should not be null");
    }

    @Test
    void testPaymentId() {
        // Check if payment ID is as expected
        assertEquals(1, testPayment.getId(), "Payment ID should be 1");
    }

    @Test
    void testPaymentUser() {
        // Check if the user is set correctly
        assertNotNull(testPayment.getUser(), "User should not be null");
        assertEquals(testUser, testPayment.getUser(), "User should match the testUser");
    }

    @Test
    void testPaymentProject() {
        // Check if the project is set correctly
        assertNotNull(testPayment.getProject(), "Project should not be null");
        assertEquals(testProject, testPayment.getProject(), "Project should match the testProject");
    }

    @Test
    void testPaymentAmount() {
        // Check if payment amount is as expected
        assertEquals(100.0f, testPayment.getAmount(), "Payment amount should be 100.0");
    }

    @Test
    void testPaymentDate() {
        // Check if payment date is not null
        assertNotNull(testPayment.getPaymentDate(), "Payment date should not be null");
        // Check if the payment date is today (this is just an example check)
        assertTrue(testPayment.getPaymentDate().before(new Date()) || testPayment.getPaymentDate().equals(new Date()), "Payment date should be today or earlier");
    }
}

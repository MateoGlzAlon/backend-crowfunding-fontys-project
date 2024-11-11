package com.fontys.crowdfund.testPersistence.Entity;

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

    // Group 1: Initialization Tests
    @Test
    void testPaymentNotNull() {
        // Check if testPayment is not null
        assertNotNull(testPayment, "Test payment should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that a PaymentEntity can be created using no-args constructor
        PaymentEntity payment = new PaymentEntity();
        assertNotNull(payment, "PaymentEntity created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that a PaymentEntity can be created with all args constructor
        PaymentEntity payment = new PaymentEntity(2, testUser, testProject, 200.0f, new Date());
        assertNotNull(payment, "PaymentEntity created with all-args constructor should not be null");
        assertEquals(2, payment.getId(), "Payment ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that a PaymentEntity can be created using the builder
        PaymentEntity payment = PaymentEntity.builder()
                .id(3)
                .user(testUser)
                .project(testProject)
                .amount(300.0f)
                .paymentDate(new Date())
                .build();

        assertNotNull(payment, "PaymentEntity created with builder should not be null");
        assertEquals(300.0f, payment.getAmount(), "Payment amount should be 300.0");
    }

    // Group 2: Getter Tests
    @Test
    void testPaymentId() {
        // Check if payment ID is as expected
        assertEquals(1, testPayment.getId(), "Payment ID should be 1");
    }

    @Test
    void testPaymentUser() {
        // Check if the user is set correctly
        assertEquals(testUser, testPayment.getUser(), "User should match the testUser");
    }

    @Test
    void testPaymentProject() {
        // Check if the project is set correctly
        assertEquals(testProject, testPayment.getProject(), "Project should match the testProject");
    }

    @Test
    void testPaymentAmount() {
        // Check if payment amount is as expected
        assertEquals(100.0f, testPayment.getAmount(), "Payment amount should be 100.0");
    }

    @Test
    void testPaymentDate() {
        // Check if payment date is set correctly
        assertNotNull(testPayment.getPaymentDate(), "Payment date should not be null");
    }

    // Group 3: Setter Tests
    @Test
    void testSetId() {
        // Set a new ID
        testPayment.setId(2);
        assertEquals(2, testPayment.getId(), "Payment ID should be 2");
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
        testPayment.setUser(newUser);
        assertEquals(newUser, testPayment.getUser(), "User should match the new user");
    }

    @Test
    void testSetProject() {
        // Set a new project
        ProjectEntity newProject = ProjectEntity.builder()
                .id(2)
                .name("New Project")
                .build();
        testPayment.setProject(newProject);
        assertEquals(newProject, testPayment.getProject(), "Project should match the new project");
    }

    @Test
    void testSetAmount() {
        // Set a new amount
        testPayment.setAmount(150.0f);
        assertEquals(150.0f, testPayment.getAmount(), "Payment amount should be 150.0");
    }

    @Test
    void testSetPaymentDate() {
        // Set a new payment date
        Date newDate = new Date();
        testPayment.setPaymentDate(newDate);
        assertEquals(newDate, testPayment.getPaymentDate(), "Payment date should match the new date");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another payment with the same values
        PaymentEntity paymentToCompare = PaymentEntity.builder()
                .id(1)
                .user(testUser)
                .project(testProject)
                .amount(100.0f)
                .paymentDate(testPayment.getPaymentDate())
                .build();

        assertEquals(testPayment, paymentToCompare, "Payments should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another payment with different values
        PaymentEntity paymentToCompare = PaymentEntity.builder()
                .id(2)
                .user(testUser)
                .project(testProject)
                .amount(200.0f)
                .paymentDate(new Date())
                .build();

        assertNotEquals(testPayment, paymentToCompare, "Payments should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another payment with the same values
        PaymentEntity paymentToCompare = PaymentEntity.builder()
                .id(1)
                .user(testUser)
                .project(testProject)
                .amount(100.0f)
                .paymentDate(testPayment.getPaymentDate())
                .build();

        assertEquals(testPayment.hashCode(), paymentToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "PaymentEntity(id=1, user=" + testUser + ", project=" + testProject + ", amount=100.0, paymentDate=" + testPayment.getPaymentDate() + ")";
        assertEquals(expected, testPayment.toString(), "toString method should return the expected output");
    }
}

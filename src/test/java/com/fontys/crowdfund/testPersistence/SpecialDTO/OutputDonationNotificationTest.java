package com.fontys.crowdfund.testPersistence.SpecialDTO;

import com.fontys.crowdfund.persistence.specialDTO.OutputDonationNotification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OutputDonationNotificationTest {

    private OutputDonationNotification testNotificationDTO;
    private Date testDate;

    @BeforeEach
    void setUp() {
        // Set up test data
        testDate = new Date();

        // Initialize testNotificationDTO
        testNotificationDTO = OutputDonationNotification.builder()
                .amount(100.0f)
                .backerName("John Doe")
                .paymentDate(testDate)
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testNotificationDTONotNull() {
        // Check if testNotificationDTO is not null
        assertNotNull(testNotificationDTO, "Test NotificationDTO should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that an OutputDonationNotification can be created using no-args constructor
        OutputDonationNotification notificationDTO = new OutputDonationNotification();
        assertNotNull(notificationDTO, "OutputDonationNotification created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an OutputDonationNotification can be created with all args constructor
        OutputDonationNotification notificationDTO = new OutputDonationNotification(
                200.0f,
                "Jane Doe",
                testDate
        );
        assertNotNull(notificationDTO, "OutputDonationNotification created with all-args constructor should not be null");
        assertEquals(200.0f, notificationDTO.getAmount(), "Amount should be 200.0");
    }

    @Test
    void testBuilder() {
        // Ensure that an OutputDonationNotification can be created using the builder
        OutputDonationNotification notificationDTO = OutputDonationNotification.builder()
                .amount(300.0f)
                .backerName("Builder User")
                .paymentDate(testDate)
                .build();

        assertNotNull(notificationDTO, "OutputDonationNotification created with builder should not be null");
        assertEquals("Builder User", notificationDTO.getBackerName(), "Backer name should be 'Builder User'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetAmount() {
        // Check if the amount is as expected
        assertEquals(100.0f, testNotificationDTO.getAmount(), "Amount should be 100.0");
    }

    @Test
    void testGetBackerName() {
        // Check if the backer name is as expected
        assertEquals("John Doe", testNotificationDTO.getBackerName(), "Backer name should be 'John Doe'");
    }

    @Test
    void testGetPaymentDate() {
        // Check if the payment date is as expected
        assertEquals(testDate, testNotificationDTO.getPaymentDate(), "Payment date should match the testDate");
    }

    // Group 3: Setter Tests
    @Test
    void testSetAmount() {
        // Set a new amount
        testNotificationDTO.setAmount(150.0f);
        assertEquals(150.0f, testNotificationDTO.getAmount(), "Amount should be 150.0");
    }

    @Test
    void testSetBackerName() {
        // Set a new backer name
        testNotificationDTO.setBackerName("Jane Doe");
        assertEquals("Jane Doe", testNotificationDTO.getBackerName(), "Backer name should be 'Jane Doe'");
    }

    @Test
    void testSetPaymentDate() {
        // Set a new payment date
        Date newDate = new Date();
        testNotificationDTO.setPaymentDate(newDate);
        assertEquals(newDate, testNotificationDTO.getPaymentDate(), "Payment date should match the new date");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another NotificationDTO with the same values
        OutputDonationNotification notificationToCompare = OutputDonationNotification.builder()
                .amount(100.0f)
                .backerName("John Doe")
                .paymentDate(testDate)
                .build();

        assertEquals(testNotificationDTO, notificationToCompare, "Notification DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another NotificationDTO with different values
        OutputDonationNotification notificationToCompare = OutputDonationNotification.builder()
                .amount(200.0f)
                .backerName("Jane Doe")
                .paymentDate(new Date())
                .build();

        assertNotEquals(testNotificationDTO, notificationToCompare, "Notification DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another NotificationDTO with the same values
        OutputDonationNotification notificationToCompare = OutputDonationNotification.builder()
                .amount(100.0f)
                .backerName("John Doe")
                .paymentDate(testDate)
                .build();

        assertEquals(testNotificationDTO.hashCode(), notificationToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "OutputDonationNotification(amount=100.0, backerName=John Doe, paymentDate=" + testDate + ")";
        assertEquals(expected, testNotificationDTO.toString(), "toString method should return the expected output");
    }
}

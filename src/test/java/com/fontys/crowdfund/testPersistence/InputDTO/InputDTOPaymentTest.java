package com.fontys.crowdfund.testPersistence.InputDTO;

import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class InputDTOPaymentTest {

    private InputDTOPayment testPaymentDTO;

    @BeforeEach
    void setUp() {
        // Initialize testPaymentDTO
        testPaymentDTO = InputDTOPayment.builder()
                .projectId(1)
                .backerEmail("backer@example.com")
                .amountFunded(150.0f)
                .paymentDate(new Date())
                .build();
    }

    // Group 1: Initialization Tests
    @Test
    void testPaymentDTONotNull() {
        // Check if testPaymentDTO is not null
        assertNotNull(testPaymentDTO, "Test PaymentDTO should not be null");
    }

    @Test
    void testNoArgsConstructor() {
        // Ensure that an InputDTOPayment can be created using no-args constructor
        InputDTOPayment paymentDTO = new InputDTOPayment();
        assertNotNull(paymentDTO, "InputDTOPayment created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an InputDTOPayment can be created with all args constructor
        Date date = new Date();
        InputDTOPayment paymentDTO = new InputDTOPayment(2, "supporter@example.com", 250.0f, date);
        assertNotNull(paymentDTO, "InputDTOPayment created with all-args constructor should not be null");
        assertEquals(2, paymentDTO.getProjectId(), "Project ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that an InputDTOPayment can be created using the builder
        Date date = new Date();
        InputDTOPayment paymentDTO = InputDTOPayment.builder()
                .projectId(3)
                .backerEmail("another@example.com")
                .amountFunded(350.0f)
                .paymentDate(date)
                .build();

        assertNotNull(paymentDTO, "InputDTOPayment created with builder should not be null");
        assertEquals("another@example.com", paymentDTO.getBackerEmail(), "Backer email should match 'another@example.com'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetProjectId() {
        // Check if the project ID is as expected
        assertEquals(1, testPaymentDTO.getProjectId(), "Project ID should be 1");
    }

    @Test
    void testGetBackerEmail() {
        // Check if the backer email is as expected
        assertEquals("backer@example.com", testPaymentDTO.getBackerEmail(), "Backer email should be 'backer@example.com'");
    }

    @Test
    void testGetAmountFunded() {
        // Check if the amount funded is as expected
        assertEquals(150.0f, testPaymentDTO.getAmountFunded(), "Amount funded should be 150.0");
    }

    @Test
    void testGetPaymentDate() {
        // Check if the payment date is set correctly
        assertNotNull(testPaymentDTO.getPaymentDate(), "Payment date should not be null");
    }

    // Group 3: Setter Tests
    @Test
    void testSetProjectId() {
        // Set a new project ID
        testPaymentDTO.setProjectId(2);
        assertEquals(2, testPaymentDTO.getProjectId(), "Project ID should be 2");
    }

    @Test
    void testSetBackerEmail() {
        // Set a new backer email
        testPaymentDTO.setBackerEmail("newbacker@example.com");
        assertEquals("newbacker@example.com", testPaymentDTO.getBackerEmail(), "Backer email should be 'newbacker@example.com'");
    }

    @Test
    void testSetAmountFunded() {
        // Set a new amount funded
        testPaymentDTO.setAmountFunded(200.0f);
        assertEquals(200.0f, testPaymentDTO.getAmountFunded(), "Amount funded should be 200.0");
    }

    @Test
    void testSetPaymentDate() {
        // Set a new payment date
        Date newDate = new Date();
        testPaymentDTO.setPaymentDate(newDate);
        assertEquals(newDate, testPaymentDTO.getPaymentDate(), "Payment date should match the new date");
    }

    // Group 4: Object Method Tests (equals, hashCode, toString)
    @Test
    void testEquals() {
        // Create another InputDTOPayment with the same values
        InputDTOPayment paymentToCompare = InputDTOPayment.builder()
                .projectId(1)
                .backerEmail("backer@example.com")
                .amountFunded(150.0f)
                .paymentDate(testPaymentDTO.getPaymentDate())
                .build();

        assertEquals(testPaymentDTO, paymentToCompare, "Payments should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another InputDTOPayment with different values
        InputDTOPayment paymentToCompare = InputDTOPayment.builder()
                .projectId(2)
                .backerEmail("different@example.com")
                .amountFunded(200.0f)
                .paymentDate(new Date())
                .build();

        assertNotEquals(testPaymentDTO, paymentToCompare, "Payments should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another InputDTOPayment with the same values
        InputDTOPayment paymentToCompare = InputDTOPayment.builder()
                .projectId(1)
                .backerEmail("backer@example.com")
                .amountFunded(150.0f)
                .paymentDate(testPaymentDTO.getPaymentDate())
                .build();

        assertEquals(testPaymentDTO.hashCode(), paymentToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "InputDTOPayment(projectId=1, backerEmail=backer@example.com, amountFunded=150.0, paymentDate=" + testPaymentDTO.getPaymentDate() + ")";
        assertEquals(expected, testPaymentDTO.toString(), "toString method should return the expected output");
    }
}

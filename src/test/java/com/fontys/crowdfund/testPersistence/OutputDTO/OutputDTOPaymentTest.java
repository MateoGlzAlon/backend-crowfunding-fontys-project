package com.fontys.crowdfund.testPersistence;

import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OutputDTOPaymentTest {

    private OutputDTOPayment testPaymentDTO;
    private Date testDate;

    @BeforeEach
    void setUp() {
        // Set up test data
        testDate = new Date();

        // Initialize testPaymentDTO
        testPaymentDTO = OutputDTOPayment.builder()
                .paymentId(1)
                .projectId(101)
                .backerEmail("backer@example.com")
                .amountFunded(250.0)
                .paymentDate(testDate)
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
        // Ensure that an OutputDTOPayment can be created using no-args constructor
        OutputDTOPayment paymentDTO = new OutputDTOPayment();
        assertNotNull(paymentDTO, "OutputDTOPayment created with no-args constructor should not be null");
    }

    @Test
    void testAllArgsConstructor() {
        // Ensure that an OutputDTOPayment can be created with all args constructor
        OutputDTOPayment paymentDTO = new OutputDTOPayment(2, 202, "supporter@example.com", 500.0, testDate);
        assertNotNull(paymentDTO, "OutputDTOPayment created with all-args constructor should not be null");
        assertEquals(2, paymentDTO.getPaymentId(), "Payment ID should be 2");
    }

    @Test
    void testBuilder() {
        // Ensure that an OutputDTOPayment can be created using the builder
        OutputDTOPayment paymentDTO = OutputDTOPayment.builder()
                .paymentId(3)
                .projectId(303)
                .backerEmail("builder@example.com")
                .amountFunded(600.0)
                .paymentDate(testDate)
                .build();

        assertNotNull(paymentDTO, "OutputDTOPayment created with builder should not be null");
        assertEquals("builder@example.com", paymentDTO.getBackerEmail(), "Backer email should match 'builder@example.com'");
    }

    // Group 2: Getter Tests
    @Test
    void testGetPaymentId() {
        // Check if the payment ID is as expected
        assertEquals(1, testPaymentDTO.getPaymentId(), "Payment ID should be 1");
    }

    @Test
    void testGetProjectId() {
        // Check if the project ID is as expected
        assertEquals(101, testPaymentDTO.getProjectId(), "Project ID should be 101");
    }

    @Test
    void testGetBackerEmail() {
        // Check if the backer email is as expected
        assertEquals("backer@example.com", testPaymentDTO.getBackerEmail(), "Backer email should be 'backer@example.com'");
    }

    @Test
    void testGetAmountFunded() {
        // Check if the amount funded is as expected
        assertEquals(250.0, testPaymentDTO.getAmountFunded(), "Amount funded should be 250.0");
    }

    @Test
    void testGetPaymentDate() {
        // Check if the payment date is as expected
        assertEquals(testDate, testPaymentDTO.getPaymentDate(), "Payment date should match the testDate");
    }

    // Group 3: Setter Tests
    @Test
    void testSetPaymentId() {
        // Set a new payment ID
        testPaymentDTO.setPaymentId(2);
        assertEquals(2, testPaymentDTO.getPaymentId(), "Payment ID should be 2");
    }

    @Test
    void testSetProjectId() {
        // Set a new project ID
        testPaymentDTO.setProjectId(202);
        assertEquals(202, testPaymentDTO.getProjectId(), "Project ID should be 202");
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
        testPaymentDTO.setAmountFunded(300.0);
        assertEquals(300.0, testPaymentDTO.getAmountFunded(), "Amount funded should be 300.0");
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
        // Create another OutputDTOPayment with the same values
        OutputDTOPayment paymentToCompare = OutputDTOPayment.builder()
                .paymentId(1)
                .projectId(101)
                .backerEmail("backer@example.com")
                .amountFunded(250.0)
                .paymentDate(testDate)
                .build();

        assertEquals(testPaymentDTO, paymentToCompare, "Payment DTOs should be equal");
    }

    @Test
    void testNotEquals() {
        // Create another OutputDTOPayment with different values
        OutputDTOPayment paymentToCompare = OutputDTOPayment.builder()
                .paymentId(2)
                .projectId(202)
                .backerEmail("different@example.com")
                .amountFunded(500.0)
                .paymentDate(new Date())
                .build();

        assertNotEquals(testPaymentDTO, paymentToCompare, "Payment DTOs should not be equal");
    }

    @Test
    void testHashCode() {
        // Create another OutputDTOPayment with the same values
        OutputDTOPayment paymentToCompare = OutputDTOPayment.builder()
                .paymentId(1)
                .projectId(101)
                .backerEmail("backer@example.com")
                .amountFunded(250.0)
                .paymentDate(testDate)
                .build();

        assertEquals(testPaymentDTO.hashCode(), paymentToCompare.hashCode(), "Hash codes should be equal");
    }

    @Test
    void testToString() {
        String expected = "OutputDTOPayment(paymentId=1, projectId=101, backerEmail=backer@example.com, amountFunded=250.0, paymentDate=" + testDate + ")";
        assertEquals(expected, testPaymentDTO.toString(), "toString method should return the expected output");
    }
}

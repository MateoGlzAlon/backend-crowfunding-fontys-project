package com.fontys.crowdfund.persistence.impl;

import com.fontys.crowdfund.model.Payment;
import com.fontys.crowdfund.persistence.PaymentRepository;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    private static int NEXT_ID = 1;
    private final List<Payment> savedPayments;

    public PaymentRepositoryImpl() {
        this.savedPayments = new ArrayList<>();
    }


    @Override
    public boolean existsById(long paymentId) {
        return this.savedPayments
                .stream()
                .anyMatch(payment -> payment.getPaymentId() == paymentId);
    }

    @Override
    public OutputDTOPayment findById(long paymentId) {
        Payment payment = this.savedPayments
                .stream()
                .filter(u -> u.getPaymentId() == paymentId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));

        return convertToDTO(payment); // Use the utility method for conversion
    }

    @Override
    public OutputDTOPayment save(Payment payment) {
        payment.setPaymentId(NEXT_ID);
        NEXT_ID++;
        savedPayments.add(payment);
        return convertToDTO(payment); // Use the utility method for conversion
    }

    @Override
    public List<OutputDTOPayment> findAll() {
        return this.savedPayments.stream()
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return this.savedPayments.size();
    }

    @Override
    public OutputDTOPayment deleteById(int id) {
        for (Payment payment : this.savedPayments) {
            if (payment.getPaymentId() == id) {
                this.savedPayments.remove(payment);
                return convertToDTO(payment); // Use the utility method for conversion
            }
        }
        return null; // or throw new PaymentNotFoundException("Payment not found with ID: " + id);
    }

    @Override
    public List<OutputDTOPayment> getPaymentsByProjectId(int id) {
        return this.savedPayments.stream()
                .filter(project -> project.getProjectId() == id) // Filter projects
                .sorted((payment1, payment2) -> payment1.getPaymentDate().compareTo(payment2.getPaymentDate())) // Sort by date in descending order
                .map(this::convertToDTO) // Use the utility method for conversion
                .collect(Collectors.toList()); // Collect and return as a List
         }

    // Utility method to convert Payment to OutputDTOPayment
    private OutputDTOPayment convertToDTO(Payment payment) {
        return OutputDTOPayment.builder()
                .paymentId(payment.getPaymentId())
                .backerEmail(payment.getBackerEmail())
                .paymentDate(payment.getPaymentDate())
                .amountFunded(payment.getAmountFunded())
                .projectId(payment.getProjectId())
                .build();
    }
}

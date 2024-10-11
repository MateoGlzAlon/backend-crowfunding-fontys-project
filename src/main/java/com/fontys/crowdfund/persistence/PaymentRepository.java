package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.model.Payment;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;

import java.util.List;

public interface PaymentRepository {

    // Check if a payment exists by ID
    boolean existsById(long paymentId);

    // Find a payment by ID
    OutputDTOPayment findById(long paymentId);

    // Save a payment (create or update)
    OutputDTOPayment save(Payment payment);

    // Find all payments
    List<OutputDTOPayment> findAll();

    // Get the count of payments
    int count();

    OutputDTOPayment deleteById(int id);

    List<OutputDTOPayment> getPaymentsByProjectId(int id);
}

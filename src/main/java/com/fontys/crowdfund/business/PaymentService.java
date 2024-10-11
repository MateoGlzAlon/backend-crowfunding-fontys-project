package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;

import java.util.List;

public interface PaymentService {

    // Get all payments and convert them to DTOs
    List<OutputDTOPayment> getAllPayments();

    // Get payment by ID
    OutputDTOPayment getPaymentById(long id);

    // Create a new payment
    OutputDTOPayment createPayment(InputDTOPayment paymentDTO);

    OutputDTOPayment deletePayment(int id);

    List<OutputDTOPayment> getPaymentsByProjectId(int id);
}

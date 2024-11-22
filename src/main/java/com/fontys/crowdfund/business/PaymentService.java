package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOPayment;
import com.fontys.crowdfund.persistence.specialDTO.OutputDonationNotification;

import java.util.List;

public interface PaymentService {

    // Get all payments and convert them to DTOs
    List<OutputDTOPayment> getAllPayments();

    // Get payment by ID
    OutputDTOPayment getPaymentById(long id);

    // Create a new payment
    OutputDTOPayment createPayment(InputDTOPayment paymentDTO);

    void deletePaymentById(int id);

    List<OutputDTOPayment> getPaymentsByProjectId(int id);

    List<OutputDonationNotification> getPaymentNotificationsByProjectId(int id);
}

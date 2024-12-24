package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.specialdto.OutputDonationNotification;
import com.fontys.crowdfund.persistence.specialdto.ProfilePaymentDTO;

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

    List<ProfilePaymentDTO> getPaymentsByUserIdForProfile(int id);

    Integer getTotalPaymentsByUserId(int userId, String time);
}

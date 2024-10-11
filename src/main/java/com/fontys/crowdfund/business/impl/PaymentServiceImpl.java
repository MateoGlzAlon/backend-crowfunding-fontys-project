package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.business.PaymentService;
import com.fontys.crowdfund.exception.EmailAlreadyExists;
import com.fontys.crowdfund.model.Payment;
import com.fontys.crowdfund.persistence.PaymentRepository;
import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    // Get all payments and convert them to DTOs
    @Override
    public List<OutputDTOPayment> getAllPayments() {
        return new ArrayList<>(paymentRepository.findAll());
    }

    // Get payment by ID
    @Override
    public OutputDTOPayment getPaymentById(long id) {
        return paymentRepository.findById(id);
    }

    // Create a new payment
    @Override
    public OutputDTOPayment createPayment(InputDTOPayment paymentDTO) {

        Payment payment = Payment.builder()
                .backerEmail(paymentDTO.getBackerEmail())
                .amountFunded(paymentDTO.getAmountFunded())
                .paymentDate(paymentDTO.getPaymentDate())
                .projectId(paymentDTO.getProjectId())
                .build();

        return paymentRepository.save(payment);
    }

    @Override
    public OutputDTOPayment deletePayment(int id) {

        return paymentRepository.deleteById(id);

    }

    @Override
    public List<OutputDTOPayment> getPaymentsByProjectId(int id) {
        return paymentRepository.getPaymentsByProjectId(id);
    }


}

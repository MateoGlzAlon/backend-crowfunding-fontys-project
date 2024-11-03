package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.persistence.PaymentRepository;

import com.fontys.crowdfund.business.PaymentService;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.entity.PaymentEntity;
import com.fontys.crowdfund.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    // Get all payments and convert them to DTOs
    @Override
    public List<OutputDTOPayment> getAllPayments() {
        List<OutputDTOPayment> outputDTOPayments = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentRepository.findAll()) {
            outputDTOPayments.add(createOutputDTOPayment(paymentEntity));
        }

        return outputDTOPayments;
    }



    // Get payment by ID
    @Override
    public OutputDTOPayment getPaymentById(long id) {
        return paymentRepository.findById(id)
                .map(this::createOutputDTOPayment)
                .orElse(null);
    }

    // Create a new payment
    @Override
    public OutputDTOPayment createPayment(InputDTOPayment paymentDTO) {

        System.out.println("PaymentDTO es : " + paymentDTO);
        System.out.println("1A");
        System.out.println("back ema: " + paymentDTO.getBackerEmail());
        UserEntity u1 = userRepository.findByEmail(paymentDTO.getBackerEmail());

        System.out.println("UserEnt1 es " + u1.getName());
        System.out.println("2A");
        System.out.println("ProjectEnt es " + projectRepository.findById(paymentDTO.getProjectId()));
        System.out.println("3A");

        PaymentEntity payment = PaymentEntity.builder()
                .user(userRepository.findByEmail(paymentDTO.getBackerEmail()))
                .project(projectRepository.findById(paymentDTO.getProjectId()).orElse(null))
                .amount(paymentDTO.getAmountFunded())
                .paymentDate(paymentDTO.getPaymentDate())
                .build();
        System.out.println("4A");
        System.out.println("Payment es : " + payment);

        return createOutputDTOPayment(paymentRepository.save(payment));
    }

    @Override
    public void deletePaymentById(int id) {

        paymentRepository.deleteById((long) id);

    }

    @Override
    public List<OutputDTOPayment> getPaymentsByProjectId(int id) {

        List<OutputDTOPayment> outputDTOPayments = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentRepository.getPaymentsByProjectId(id)) {
            outputDTOPayments.add(createOutputDTOPayment(paymentEntity));
        }

        return outputDTOPayments;
    }


    private OutputDTOPayment createOutputDTOPayment(PaymentEntity paymentEntity) {

        return OutputDTOPayment.builder()
                .paymentId(paymentEntity.getId())
                .paymentDate(paymentEntity.getPaymentDate())
                .projectId(paymentEntity.getProject().getId())
                .backerEmail(paymentEntity.getUser().getEmail())
                .amountFunded(paymentEntity.getAmount())
                .build();
    }

}

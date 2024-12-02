package com.fontys.crowdfund.business.impl;

import com.fontys.crowdfund.persistence.PaymentRepository;

import com.fontys.crowdfund.business.PaymentService;
import com.fontys.crowdfund.persistence.ProjectRepository;
import com.fontys.crowdfund.persistence.UserRepository;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOPayment;
import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.entity.PaymentEntity;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.specialdto.OutputDonationNotification;
import com.fontys.crowdfund.persistence.specialdto.ProfilePaymentDTO;
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

        PaymentEntity payment = PaymentEntity.builder()
                .user(userRepository.findById(paymentDTO.getBackerId()))
                .project(projectRepository.findById(paymentDTO.getProjectId()).orElse(null))
                .amount(paymentDTO.getAmountFunded())
                .paymentDate(paymentDTO.getPaymentDate())
                .build();


        ProjectEntity project = projectRepository.findById(paymentDTO.getProjectId()).orElse(null);
        project.setMoneyRaised(project.getMoneyRaised() + paymentDTO.getAmountFunded());
        projectRepository.save(project);

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

    @Override
    public List<OutputDonationNotification> getPaymentNotificationsByProjectId(int id) {
        List<OutputDonationNotification> outputDTOPaymentNotification = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentRepository.getPaymentsByProjectId(id)) {

            OutputDonationNotification outputDonationNotification = OutputDonationNotification.builder()
                    .backerName(paymentEntity.getUser().getName())
                    .paymentDate(paymentEntity.getPaymentDate())
                    .amount(paymentEntity.getAmount())
                    .build();

            outputDTOPaymentNotification.add(outputDonationNotification);
        }

        return outputDTOPaymentNotification;
    }

    @Override
    public List<ProfilePaymentDTO> getPaymentsByUserIdForProfile(int id) {
        List<ProfilePaymentDTO> profilePaymentDTOs = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentRepository.getPaymentsByUserIdForProfile(id)) {

            ProfilePaymentDTO profilePaymentDTO = ProfilePaymentDTO.builder()
                    .id(paymentEntity.getId())
                    .projectId(paymentEntity.getProject().getId())
                    .projectName(paymentEntity.getProject().getName())
                    .projectOwnerName(paymentEntity.getUser().getName())
                    .paymentDate(paymentEntity.getPaymentDate())
                    .amountFunded(paymentEntity.getAmount())
                    .projectCoverImage(paymentRepository.getImageCover(paymentEntity.getProject().getId()))
                    .build();


            profilePaymentDTOs.add(profilePaymentDTO);
        }

        return profilePaymentDTOs;
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

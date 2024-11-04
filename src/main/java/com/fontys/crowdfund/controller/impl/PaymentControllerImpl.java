package com.fontys.crowdfund.controller.impl;

import com.fontys.crowdfund.controller.PaymentController;
import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import com.fontys.crowdfund.business.PaymentService;
import com.fontys.crowdfund.persistence.specialDTO.OutputDonationNotification;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentControllerImpl implements PaymentController {

    private PaymentService paymentService;

    @Override
    @GetMapping
    public List<OutputDTOPayment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OutputDTOPayment> getPaymentById(@PathVariable int id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @Override
    @GetMapping("/projects/{id}")
    public ResponseEntity<List<OutputDTOPayment>> getPaymentsToProjectById(@PathVariable int id) {
        return ResponseEntity.ok(paymentService.getPaymentsByProjectId(id));
    }

    @Override
    @GetMapping("/projects/notifications/{id}")
    public ResponseEntity<List<OutputDonationNotification>> getPaymentNotificationsToProjectById(@PathVariable int id) {
        return ResponseEntity.ok(paymentService.getPaymentNotificationsByProjectId(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<OutputDTOPayment> createPayment(@RequestBody InputDTOPayment paymentDTO) {
        return ResponseEntity.ok(paymentService.createPayment(paymentDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<OutputDTOPayment> deletePayment(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}

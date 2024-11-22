// PaymentController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOPayment;
import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOPayment;
import com.fontys.crowdfund.persistence.specialDTO.OutputDonationNotification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PaymentController {

    @GetMapping
    List<OutputDTOPayment> getAllPayments();

    @GetMapping("/{id}")
    ResponseEntity<OutputDTOPayment> getPaymentById(@PathVariable int id);

    @GetMapping("/projects/{id}")
    ResponseEntity<List<OutputDTOPayment>> getPaymentsToProjectById(@PathVariable int id);

    @GetMapping("/projects/{id}")
    ResponseEntity<List<OutputDonationNotification>> getPaymentNotificationsToProjectById(@PathVariable int id);

    @PostMapping
    ResponseEntity<OutputDTOPayment> createPayment(@RequestBody InputDTOPayment paymentDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOPayment> deletePayment(@PathVariable int id);

}

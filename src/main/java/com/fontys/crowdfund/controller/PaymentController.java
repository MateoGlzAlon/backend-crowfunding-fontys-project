// PaymentController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.outputdto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.dto.inputdto.InputDTOPayment;
import com.fontys.crowdfund.persistence.specialdto.OutputDonationNotification;
import com.fontys.crowdfund.persistence.specialdto.ProfilePaymentDTO;
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

    @GetMapping("/projects/profile/{id}")
    ResponseEntity<List<ProfilePaymentDTO>> getPaymentsByUserIdForProfile(@PathVariable int id);

    @PostMapping
    ResponseEntity<OutputDTOPayment> createPayment(@RequestBody InputDTOPayment paymentDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOPayment> deletePayment(@PathVariable int id);

}

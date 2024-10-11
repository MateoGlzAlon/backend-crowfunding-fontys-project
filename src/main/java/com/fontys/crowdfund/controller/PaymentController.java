// PaymentController.java
package com.fontys.crowdfund.controller;

import com.fontys.crowdfund.persistence.dto.OutputDTOPayment;
import com.fontys.crowdfund.persistence.dto.InputDTOPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PaymentController {

    @GetMapping
    List<OutputDTOPayment> getAllPayments();

    @GetMapping("/{id}")
    ResponseEntity<OutputDTOPayment> getPaymentById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<OutputDTOPayment> createPayment(@RequestBody InputDTOPayment paymentDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<OutputDTOPayment> deleteProject(@PathVariable int id);
}

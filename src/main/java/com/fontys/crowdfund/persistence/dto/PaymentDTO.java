package com.fontys.crowdfund.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private long id;
    private double amount;
    private Date date;

    // Payment is linked to user and project IDs
    private long userId;
    private long projectId;
}

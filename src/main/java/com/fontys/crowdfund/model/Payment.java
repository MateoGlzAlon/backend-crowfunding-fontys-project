package com.fontys.crowdfund.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Payment {

    private int paymentId;

    private int projectId;
    private String backerEmail;
    private double amountFunded;
    private Date paymentDate;

}

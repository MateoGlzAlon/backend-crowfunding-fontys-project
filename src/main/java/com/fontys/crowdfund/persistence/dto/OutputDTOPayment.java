package com.fontys.crowdfund.persistence.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OutputDTOPayment {

    private int paymentId;
    private int projectId;
    private String backerEmail;
    private double amountFunded;
    private Date paymentDate;

}

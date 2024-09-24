package com.crowfund.crowdfundingproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Payment {
    private int id;
    private int paymentId;
    private int customerId;
    private String paymentDate;
    private float amount;

}

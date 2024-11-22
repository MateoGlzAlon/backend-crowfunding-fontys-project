package com.fontys.crowdfund.persistence.dto.InputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputDTOPayment {

    private int projectId;
    private String backerEmail;
    private float amountFunded;
    private Date paymentDate;

}

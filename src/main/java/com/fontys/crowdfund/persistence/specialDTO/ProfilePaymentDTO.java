package com.fontys.crowdfund.persistence.specialDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePaymentDTO {

    private int id;
    private String projectName;
    private Date paymentDate;
    private float amountFunded;
    private String projectOwnerName;
    private String projectCoverImage;

}

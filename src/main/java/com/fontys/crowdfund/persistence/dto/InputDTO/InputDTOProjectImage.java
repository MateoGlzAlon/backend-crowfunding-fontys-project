package com.fontys.crowdfund.persistence.dto.InputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputDTOProjectImage {

    private int projectId;
    private String imageURL;
    private int imageOrder;

}
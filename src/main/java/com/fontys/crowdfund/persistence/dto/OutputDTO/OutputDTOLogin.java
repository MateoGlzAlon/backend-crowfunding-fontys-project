package com.fontys.crowdfund.persistence.dto.OutputDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputDTOLogin {
    private String accessToken;
}

package com.fontys.crowdfund.business;

import com.fontys.crowdfund.persistence.dto.InputDTO.InputDTOLogin;
import com.fontys.crowdfund.persistence.dto.OutputDTO.OutputDTOLogin;

public interface LoginService {
    OutputDTOLogin login(InputDTOLogin loginRequest);
}

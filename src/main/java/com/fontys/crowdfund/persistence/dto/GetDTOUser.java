package com.fontys.crowdfund.persistence.dto;

import com.fontys.crowdfund.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDTOUser {

    private long id;
    private String name;
    private String email;
}

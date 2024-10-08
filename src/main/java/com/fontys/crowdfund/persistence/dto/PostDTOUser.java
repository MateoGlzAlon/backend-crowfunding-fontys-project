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
public class PostDTOUser {

    private String name;
    private String email;
    private String password;

}

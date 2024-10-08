package com.fontys.crowdfund.persistence.dto;

import com.fontys.crowdfund.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTOProject {

    private String name;
    private String description;
    private String location;
    private String type;
    private Date created;
    private float fundingGoal;
    private String userEmail;

}

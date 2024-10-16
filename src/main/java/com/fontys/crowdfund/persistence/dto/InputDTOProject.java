package com.fontys.crowdfund.persistence.dto;

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
public class InputDTOProject {

    private String name;
    private String description;
    private String location;
    private String type;
    private Date dateCreated;
    private float fundingGoal;
    private String userEmail;
    private List<String> images;

}

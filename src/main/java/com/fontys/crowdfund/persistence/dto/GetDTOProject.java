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
public class GetDTOProject {

    private int id;
    private String name;
    private String userEmail;
    private float fundingGoal;
    private float moneyRaised;
    private List<String> images;

    private String description;
    private String location;
    private String type;
    private Date dateCreated;

}

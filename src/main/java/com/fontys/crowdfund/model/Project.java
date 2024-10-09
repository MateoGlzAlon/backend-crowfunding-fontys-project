package com.fontys.crowdfund.model;

import com.fontys.crowdfund.persistence.dto.PaymentDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class Project {

    private int id;
    private String name;
    private String description;
    private String location;
        private String type;
    private Date created;
    private User owner;
    //TO-DO
    private float fundingGoal;
    private float moneyRaised;
    private List<String> fundings;
    private List<String> images;

}

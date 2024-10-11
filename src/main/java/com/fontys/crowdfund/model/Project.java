package com.fontys.crowdfund.model;

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
    private Date dateCreated;
    private User owner;
    //TO-DO
    private float fundingGoal;
    private float moneyRaised;
    private List<Payment> fundings;
    private List<String> images;

}

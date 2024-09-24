package com.crowfund.crowdfundingproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Project {

    private long id;
    private String name;
    private String description;
    private String location;
    private String type;
    private Date created;
    private String ownerEmail;
    private List<Payment> fundings;

}

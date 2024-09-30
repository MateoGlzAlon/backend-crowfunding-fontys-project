package com.fontys.crowdfund.domain;

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
public class Project {
    private long id;
    private String name;
    private String description;
    private String location;
    private String type;
    private Date created;
    private User owner;
    private List<Payment> fundings;
}

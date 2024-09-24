package com.crowfund.crowdfundingproject.persistence.entity;

import com.crowfund.crowdfundingproject.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProjectEntity {
    private Long id;
    private String name;
    private String description;
    private String type;
    private String location;
    private Date created;
    private String ownerEmail;

}

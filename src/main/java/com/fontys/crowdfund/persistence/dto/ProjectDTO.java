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
public class ProjectDTO {
    private int id;
    private String name;
    private String description;
    private String location;
    private String type;
    private Date created;

    // Owner is represented by the email in DTO
    private String userEmail;

}

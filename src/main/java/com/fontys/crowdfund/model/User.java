package com.fontys.crowdfund.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;

    // Password is private and should not be exposed in DTOs
    private String password;

    // A user can own multiple projects
    private List<Project> ownedProjects;
}

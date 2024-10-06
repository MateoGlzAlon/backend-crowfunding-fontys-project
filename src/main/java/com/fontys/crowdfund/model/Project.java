package com.fontys.crowdfund.model;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
public class Project {

    private Long id;
    private String name;
    private String description;


}

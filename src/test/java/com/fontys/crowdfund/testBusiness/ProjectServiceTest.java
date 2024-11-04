package com.fontys.crowdfund.testBusiness;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.fontys.crowdfund.business.ProjectService;
import com.fontys.crowdfund.business.impl.ProjectServiceImpl;
import com.fontys.crowdfund.persistence.entity.ProjectEntity;
import com.fontys.crowdfund.persistence.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

}

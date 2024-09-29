package com.fontys.crowdfunding;

import com.fontys.crowdfunding.domain.Project;
import com.fontys.crowdfunding.domain.User;
import com.fontys.crowdfunding.persistence.ProjectRepository;
import com.fontys.crowdfunding.persistence.entity.ProjectEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrowdfundingApplicationTests {

	static User user1;
	static Project project1;
	private ProjectRepository projectRepository;

	@BeforeAll
	static void setUp(){
		user1 = User.builder()
				.id(1)
				.name("Mateo")
				.email("example1@email.com")
				.password("password")
				.build();

		project1 = Project.builder()
				.id(1)
				.created(new Date())
				.owner(user1)
				.name("Fund my school")
				.description("Need fundings to keep the school in my village open")
				.location("Spain")
				.type("Schools")
				.build();



	}

	@Test
	void testUserEmailIsCorrect() {
		assertEquals("example1@email.com", user1.getEmail(), "The user's email should be 'example1@email.com'");
	}

	@Test
	void testProjectOwnerIsCorrect() {
		assertEquals("Mateo", project1.getOwner().getName(), "The project owner should be 'Mateo'");
	}

	@Test
	void testProjectDescriptionIsCorrect() {
		assertEquals("Need fundings to keep the school in my village open", project1.getDescription(), "The project description should match the one provided");
	}

	@Test
	void testProjectSaveInRepository() {

		//ProjectEntity projectEntity = ProjectEntity.builder().id(Long(2)).name("Project 2").user(user1).build();

		//projectRepository.save(project1);


	}
}

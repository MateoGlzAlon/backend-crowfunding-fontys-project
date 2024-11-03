package com.fontys.crowdfund;

import com.fontys.crowdfund.persistence.ProjectRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.springframework.test.util.AssertionErrors.assertEquals;


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
				.dateCreated(new Date())
				.owner(user1)
				.name("Fund my school")
				.description("Need fundings to keep the school in my village open")
				.location("Spain")
				.type("Schools")
				.build();

	}

	@Test
	void testUserEmailIsCorrect() {
		assertEquals("Email does not match the user's", user1.getEmail(), "example1@email.com");
	}

	@Test
	void testProjectOwnerIsCorrect() {
		assertEquals("Owner's name does not match the project's", project1.getOwner().getName(), "Mateo");
	}

	@Test
	void testProjectDescriptionIsCorrect() {
		assertEquals("Project description does not match the project's", project1.getDescription(),"Need fundings to keep the school in my village open");
	}

	@Test
	void testProjectSaveInRepository() {

		//ProjectEntity projectEntity = ProjectEntity.builder().id(Long(2)).name("Project 2").user(user1).build();
		//projectRepository.save(project1);

	}
}

package com.mentor.Le_Mentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LeMentorApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LeMentorApplication.class);
        application.setAdditionalProfiles("Le_Mentor");
        application.run(args);
	}

}

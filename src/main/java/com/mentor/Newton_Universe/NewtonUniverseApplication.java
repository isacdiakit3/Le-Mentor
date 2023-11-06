package com.mentor.Newton_Universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NewtonUniverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewtonUniverseApplication.class, args);
	}

}

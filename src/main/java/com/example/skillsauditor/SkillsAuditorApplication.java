package com.example.skillsauditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.example.skillsauditor")
@SpringBootApplication
public class SkillsAuditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsAuditorApplication.class, args);
	}

}

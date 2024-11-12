package com.organazation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.organazation.system.Entity")
public class OrganazationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganazationSystemApplication.class, args);
	}

}

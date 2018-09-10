package com.sterlite.bsnl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.sterlite.bsnl")
@EnableJpaRepositories("com.sterlite.bsnl")
@EntityScan("com.sterlite.bsnl")
public class BsnlbngApplication {

	public static void main(String[] args) {
		SpringApplication.run(BsnlbngApplication.class, args);
	}
}

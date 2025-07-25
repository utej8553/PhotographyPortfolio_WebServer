package com.utej.photography;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.utej.photography.repository")
@EntityScan("com.utej.photography.model")
@ComponentScan("com.utej.photography")
public class 	PhotographyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographyApplication.class, args);
	}

}

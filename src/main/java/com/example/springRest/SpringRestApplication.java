package com.example.springRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.example.springRest.controller", "com.example.springRest.service"})
@EntityScan("com.example.springRest.entity")
@EnableJpaRepositories({"com.example.springRest.repository"})
//@EnableSwagger2
@EnableScheduling
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}

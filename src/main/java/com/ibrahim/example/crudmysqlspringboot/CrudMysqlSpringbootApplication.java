package com.ibrahim.example.crudmysqlspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudMysqlSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMysqlSpringbootApplication.class, args);
	}
}

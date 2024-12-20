package com.example.art;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ArtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtApplication.class, args);
	}

}

package com.example.gestorsp.gestorsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GestorspApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorspApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/*").allowedOrigins("*");
				registry.addMapping("/*/*").allowedOrigins("*");
				registry.addMapping("/*/*/*").allowedOrigins("*");
			}
		};
	}
}

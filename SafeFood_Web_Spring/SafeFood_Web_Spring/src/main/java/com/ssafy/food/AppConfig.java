package com.ssafy.food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ssafy.food.dto.DataParsing;

@Configuration
public class AppConfig {
	@Bean
	public DataParsing loadJson(){
		
		return new DataParsing();
	}
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");

	}
}

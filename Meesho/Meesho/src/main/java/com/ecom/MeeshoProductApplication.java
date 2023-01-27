package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties

@EntityScan(basePackages = {"com.ecom.model"}) // force scan JPA entities
public class MeeshoProductApplication {	
	public static void main(String[] args) {
		SpringApplication.run(MeeshoProductApplication.class, args);
		System.out.println("Product Server Started");
	}
}

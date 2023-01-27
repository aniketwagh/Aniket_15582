package com.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties

@EntityScan(basePackages = { "com.ecom.model" }) // force scan JPA entities
public class MeeshoOrderItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(MeeshoOrderItemApplication.class, args);
		System.out.println("OrderItem Server Started");
	}

}

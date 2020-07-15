package com.fsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SalePointInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalePointInfoServiceApplication.class, args);
	}

}

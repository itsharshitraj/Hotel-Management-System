package com.hotel.department_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroServiceApplication.class, args);
	}

}

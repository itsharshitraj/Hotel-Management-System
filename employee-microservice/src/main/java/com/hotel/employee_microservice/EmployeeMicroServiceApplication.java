package com.hotel.employee_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients


public class EmployeeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroServiceApplication.class, args);
	}

}

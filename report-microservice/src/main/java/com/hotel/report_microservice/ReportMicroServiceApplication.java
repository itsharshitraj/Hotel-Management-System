package com.hotel.report_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReportMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportMicroServiceApplication.class, args);
	}

}

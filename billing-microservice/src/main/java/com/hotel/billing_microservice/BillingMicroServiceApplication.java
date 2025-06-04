package com.hotel.billing_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BillingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingMicroServiceApplication.class, args);
	}

}

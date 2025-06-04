package com.hotel.bookingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMicroServiceApplication.class, args);
	}

}

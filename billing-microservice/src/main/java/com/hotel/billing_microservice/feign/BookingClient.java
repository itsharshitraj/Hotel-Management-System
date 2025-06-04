package com.hotel.billing_microservice.feign;

import com.hotel.billing_microservice.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "Booking-MicroService")
public interface BookingClient {
    @GetMapping("/bookings/{id}")
    Booking getBookingById(@PathVariable int id);
}

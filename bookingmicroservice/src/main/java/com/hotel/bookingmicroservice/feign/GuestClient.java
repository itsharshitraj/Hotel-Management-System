package com.hotel.bookingmicroservice.feign;

import com.hotel.bookingmicroservice.model.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GUEST-Microservice")
public interface GuestClient {
    @GetMapping("/guests/{id}")
    Guest getGuestById(@PathVariable("id") int id);
}

package com.hotel.bookingmicroservice.feign;

import com.hotel.bookingmicroservice.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Payment-MicroService")
public interface PaymentClient {
    @GetMapping("/payments/bookings/{bookingId}")
    Payment getPaymentByBookingId(@PathVariable int bookingId);
}

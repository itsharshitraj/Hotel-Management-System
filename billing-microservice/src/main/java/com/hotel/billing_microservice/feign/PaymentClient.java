package com.hotel.billing_microservice.feign;

import com.hotel.billing_microservice.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Payment-MicroService")
public interface PaymentClient {
    @GetMapping("/payments/{id}")
    Payment getPaymentById(@PathVariable int id);
}

package com.hotel.payment_microservice.repository;

import com.hotel.payment_microservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Integer> {
    Optional<Payment> findByBookingId(int bookingId);
}

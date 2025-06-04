package com.hotel.payment_microservice.service;

import com.hotel.payment_microservice.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(int id);
    Payment updatePayment(int id, Payment payment);
    void deletePayment(int id);

    Optional<Payment> getPaymentByBookingId(int bookingId);
}

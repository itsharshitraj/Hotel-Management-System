package com.hotel.payment_microservice.controller;

import com.hotel.payment_microservice.model.Payment;
import com.hotel.payment_microservice.repository.PaymentRepository;
import com.hotel.payment_microservice.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody @Valid Payment payment){
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id){
        Optional<Payment> payment= paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id,@RequestBody  @Valid Payment payment){
        Payment updated = paymentService.updatePayment(id, payment);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Payment> getPaymentByBookingId(@PathVariable int bookingId){
        Optional<Payment> payment = paymentService.getPaymentByBookingId(bookingId);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}

package com.hotel.payment_microservice.model;
import jakarta.persistence.*;

import lombok.*;
@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(nullable = false)
    private int bookingId;

    @Column(nullable = false)
    private String paymentStatus; // e.g., PENDING, DONE, FAILED

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String paymentMode; // e.g., CREDIT_CARD, CASH, ONLINE
}